/*
 * [The "BSD license"]
 * Copyright (c) 2014 Takumi Bolte, Dan Welch
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. The name of the author may not be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
grammar Carbon;

file : classDecl EOF;

classDecl
    : classImports ('@' classModifier)? 'class' Identifier ':' (funcDecl | funcDef)*
    ;

classImports
    : ('import' Identifier)*
    | 'import' Identifier (',' Identifier)*
    ;

classModifier
    : 'interface'
    ;

varDecl
    : 'let' Identifier ':' type ('=' expr)? ';'
    ;

funcDecl
    : ('@' funcModifier)? 'func' Identifier '(' ')' (':' returnType)? ';'
    ;

funcDef
    : ('@' funcModifier)? 'func' Identifier '(' ')' (':' returnType)? ':' stmtBlock? 'end'
    ;

funcModifier
    : 'public'
    | 'private'
    ;

returnType
    : 'void'
    | type
    ;

forLoop
    : 'for' Identifier ':' type ('=' expr)? 'to' expr ':' stmtBlock 'end'
    ;

whileLoop
    : 'while' expr ':' stmtBlock 'end'
    ;

condStmt
    : 'if' expr 'then' ':' stmtBlock? 'end'
    ;

stmtBlock
    : stmt+
    ;

stmt
    : 'print' expr ';'
    | varDecl
    | Identifier '=' expr ';'
    | condStmt
    | forLoop
    | whileLoop
    | 'return' expr ';'
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