grammar Box;

file : expr EOF;

stmt
    : 'print' expr
    |
    ;

decl
    : 'let' Identifier ':' type ('=' expr)?
    ;

type
    : 'int'
    | 'float'
    | 'bool'
    | 'char'
    | 'string'
    ;

expr
    : expr op=('*' | '/') expr               #InfixExp
    | expr op=('+' | '-') expr               #InfixExpr
    | expr op=('<' | '>' | '<=' | '>=') expr #RelationalExpr
    | expr op=('==' | '!=') expr             #RelationalExpr
    | primary                                #PrimaryExpr
    ;

primary
    : Integer
    | Boolean
    | Float
    | Identifier
    ;

Integer
    : DIGIT+
    ;

Boolean
    : 'true'
    | 'false'
    ;

Float
    : DIGIT+ '.' DIGIT+
    ;

Identifier
    : LETTER+ (DIGIT | LETTER)*
    ;

fragment
DIGIT
    : [0-9]
    ;

fragment
LETTER
    : [a-zA-Z]
    ;

WS : [ \t\r\n] -> skip;