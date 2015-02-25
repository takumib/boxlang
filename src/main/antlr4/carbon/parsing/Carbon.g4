grammar Carbon;

file : vardecl EOF;

vardecl
    : 'let' Identifier ':' type ('=' expr)? ';'
    ;

funcdecl
    : ('@' funcModifier)? 'func' Identifier '(' ')' (':' returnType)? ';'
    ;

funcdef
    : 'func' Identifier '(' ')' '{' stmtBlock '}'
    ;

funcModifier
    : 'public'
    | 'private'
    ;

returnType
    : 'void'
    | type
    ;

stmtBlock
    : stmt+
    ;

stmt
    : 'print' expr ';'
    | vardecl
    | Identifier '=' expr ';'
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
    | '(' expr ')'                           #ParenExpr
    | primary                                #PrimaryExpr
    ;

primary
    : Integer
    | Boolean
    | Float
    | Char
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

Char
    : '\'' LETTER '\''
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

PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';