grammar DreePo;

/*

------------- PARSER -------------

*/

program: line* EOF;

line: assignment| statement | ifBlock | whileBlock;

assignment: IDENTIFIER '=' expression;

statement: (assignment|functionCall) ';';

ifBlock: 'if' expression block ('else' elseBlock);

elseBlock: block | ifBlock;

whileBlock: WHILE expression block ('else' elseBlock);

functionCall: IDENTIFIER '(' (expression (',' expression)*)? ')';

expression
    : constant                                  #constantExpression
    | IDENTIFIER                                #identifierExpression
    | functionCall                              #functionCallExpression
    | '(' expression ')'                        #parenthesizedExpression
    | '!' expression                            #notExpression
    | expression multOp expression              #multiplicationExpression
    | expression addOp expression               #additiveExpression
    | expression compareOp expression           #comparisonExpression
    | expression boolOp expression              #booleanExpression
    ;

constant: INTEGER | FLOAT | STRING | BOOL | NULL;
boolOp: BOOL_OPERATOR;
multOp: '*' | '/' | '%';
addOp: '+' | '-';
compareOp: '==' | '!=' | '>' | '<' | '>=' | '<=';
block: '{' line* '}';

/*

------------- LEXER -------------

*/

WHILE: 'while' | 'until';
BOOL: 'true' | 'false';
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
BOOL_OPERATOR: 'and' | 'or' | 'xor';
INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: ('"' ~'"'* '"')|('\'' ~'\''*'\'');
NULL: 'null';