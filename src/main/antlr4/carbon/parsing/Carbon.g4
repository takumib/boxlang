grammar Carbon;

file : decl EOF;

stmt
    : 'print' expr
    |
    ;

decl
    : 'let' Identifier ':' type ('=' expr)? ';'
    ;

type
    : 'int'
    | 'float'
    | 'bool'
    | 'char'
    | 'string'
    ;

expr
    : expr op=('*' | '/') expr               #InfixExpr
    | expr op=('+' | '-') expr               #InfixExpr
    | expr op=('<' | '>' | '<=' | '>=') expr #RelationalExpr
    | expr op=('==' | '!=') expr             #RelationalExpr
    | primary                                #PrimaryExpr
    ;

primary
    : Integer
    | Boolean
    | Float
    | String
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

String
    : '"' LETTER+ '"'
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