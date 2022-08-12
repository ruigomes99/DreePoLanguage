// See https://aka.ms/new-console-template for more information


using Antlr4.Runtime;
using DreePo;
using DreePo.Grammer;

if (args.Length == 0)
{
    Console.WriteLine("Please, insert a valid file path");
}
else
{
    //var fileName = "Grammer/sample.dp";

    var fileName = args[0];

    var fileContents = File.ReadAllText(fileName);

    var inputStream = new AntlrInputStream(fileContents);

    var peepoLexer = new DreePoLexer(inputStream);
    var commonTokenStream = new CommonTokenStream(peepoLexer);
    var peepoParser = new DreePoParser(commonTokenStream);
    var peepoContext = peepoParser.program();
    var visitor = new DreePoVisitor();

    visitor.Visit(peepoContext);
}