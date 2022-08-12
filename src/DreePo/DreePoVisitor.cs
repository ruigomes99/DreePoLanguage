
using Antlr4.Runtime.Misc;
using DreePo.Grammer;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DreePo
{
    public class DreePoVisitor : DreePoBaseVisitor<object?>
    {
        private Dictionary<string, object?> Variables { get; } = new();

        public DreePoVisitor()
        {
            Variables["PI"] = Math.PI;
            Variables["Write"] = new Func<object?[], object?> (Write);
        }

        public override object? VisitAssignment([NotNull] DreePoParser.AssignmentContext context)
        {
            var name = context.IDENTIFIER().GetText();
            var value = Visit(context.expression());

            Variables[name] = value;

            return null;
        }

        public override object? VisitConstant([NotNull] DreePoParser.ConstantContext context)
        {
            if (context.INTEGER() != null)
                return int.Parse(context.INTEGER().GetText());

            if (context.FLOAT() != null)
                return float.Parse(context.FLOAT().GetText());

            if (context.STRING() != null)
                return context.STRING().GetText()[1..^1];

            if (context.BOOL() != null)
                return context.BOOL().GetText() == "true";

            if (context.NULL() != null)
                return null;

            throw new NotImplementedException();
        }

        public override object? VisitIdentifierExpression([NotNull] DreePoParser.IdentifierExpressionContext context)
        {
            var name = context.IDENTIFIER().GetText();

            if (!Variables.ContainsKey(name))
                throw new Exception($"Variable {name} is not defined.");

            return Variables[name];
        }

        public override object? VisitAdditiveExpression([NotNull] DreePoParser.AdditiveExpressionContext context)
        {
            var left = Visit(context.expression(0));
            var right = Visit(context.expression(1));
            var op = context.addOp().GetText();

            return op switch
            {
                "+" => Add(left, right),
                "-" => Subtract(left, right),
                _ => throw new NotImplementedException()
            };
        }

        public override object? VisitWhileBlock([NotNull] DreePoParser.WhileBlockContext context)
        {
            Func<object?, bool> condition = context.WHILE().GetText() == "while" ? IsTrue : IsFalse;

            if (condition(Visit(context.expression())))
            {
                do
                {
                    Visit(context.block());
                } while (condition(Visit(context.expression())));
            }
            else
            {
                Visit(context.elseBlock()); // not working
            }

            return null;
        }

        public override object VisitComparisonExpression([NotNull] DreePoParser.ComparisonExpressionContext context)
        {
            var left = Visit(context.expression(0));
            var right = Visit(context.expression(1));
            var op = context.compareOp().GetText();

            return op switch
            {
                "<" => LessThan(left, right),
                ">" => GreatherThan(left, right),
                _ => throw new NotImplementedException()
            };
        }

        public override object VisitFunctionCall([NotNull] DreePoParser.FunctionCallContext context)
        {
            var name = context.IDENTIFIER().GetText();
            var args = context.expression().Select(Visit).ToArray();

            if (!Variables.ContainsKey(name))
                throw new Exception($"Function {name} is not defined");

            if (!(Variables[name] is Func<object?[], object?> func))
                throw new Exception($"Variable {name} is not a function");

            return func(args);
        }

        private object? Add(object? left, object? right)
        {
            if (left is int l && right is int r)
                return l + r;

            if (left is float lf && right is float rf)
                return lf + rf;

            if (left is int lInt && right is float rFloat)
                return lInt + rFloat;

            if (left is float lFloat && right is int rInt)
                return lFloat + rInt;

            if (left is string || right is string)
                return $"{left}{right}";

            throw new Exception($"Cannot add values of types {left?.GetType()} and {right?.GetType()}.");
        }

        private object? Subtract(object? left, object? right)
        {
            if (left is int l && right is int r)
                return l - r;

            if (left is float lf && right is float rf)
                return lf - rf;

            if (left is int lInt && right is float rFloat)
                return lInt - rFloat;

            if (left is float lFloat && right is int rInt)
                return lFloat - rInt;

            throw new Exception($"Cannot subtract values of types {left?.GetType()} and {right?.GetType()}.");
        }

        private object LessThan(object? left, object? right)
        {
            if (left is int l && right is int r)
                return l < r;

            if (left is float lf && right is float rf)
                return lf < rf;

            if (left is int lInt && right is float rFloat)
                return lInt < rFloat;

            if (left is float lFloat && right is int rInt)
                return lFloat < rInt;

            throw new Exception($"Cannot compare values of types {left?.GetType()} and {right?.GetType()}.");
        }

        private object GreatherThan(object? left, object? right)
        {
            if (left is int l && right is int r)
                return l > r;

            if (left is float lf && right is float rf)
                return lf > rf;

            if (left is int lInt && right is float rFloat)
                return lInt > rFloat;

            if (left is float lFloat && right is int rInt)
                return lFloat > rInt;

            throw new Exception($"Cannot compare values of types {left?.GetType()} and {right?.GetType()}.");
        }

        private bool IsTrue(object? value)
        {
            if (value is bool b)
                return b;

            throw new Exception("Value is not boolean.");
        }

        private bool IsFalse(object? value) => !IsTrue(value);

        private object? Write(object?[] args)
        {
            foreach (var arg in args)
            {
                Console.WriteLine(arg);
            }

            return null;
        }

    }
}
