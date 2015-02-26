/*
 * [The "BSD license"]
 * Copyright (c) 2015 Takumi Bolte, Dan Welch
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

package carbon.visitor;

import carbon.parsing.CarbonBaseVisitor;
import carbon.parsing.CarbonParser;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * A print visitor implementation for Carbon.
 */
public class PrintVisitor extends CarbonBaseVisitor<Void> {

    @Override
    public Void visitClassImports(CarbonParser.ClassImportsContext ctx) {
        for(TerminalNode id : ctx.Identifier()) {
            visitTerminal(id);
        }
        return null;
    }

    @Override
    public Void visitClassDecl(CarbonParser.ClassDeclContext ctx) {
        visit(ctx.classImports());
        if(ctx.classModifier() != null) {
            visit(ctx.classModifier());
        }

        String id = ctx.id.getText();
        System.out.println(id);
        visitTerminal(ctx.Identifier());
        for(CarbonParser.FuncDeclContext fd : ctx.funcDecl()) {
            visit(fd);
        }

        for(CarbonParser.FuncDefContext fd : ctx.funcDef()) {
            visit(fd);
        }

        return null;
    }

    @Override
    public Void visitFuncDecl(CarbonParser.FuncDeclContext ctx) {
        visit(ctx.funcModifier());
        String id = ctx.id.getText();
        System.out.println(id);
        visit(ctx.funcModifier());
        return null;
    }

    @Override
    public Void visitFuncDef(CarbonParser.FuncDefContext ctx) {
        if(ctx.funcModifier() != null) {
            visit(ctx.funcModifier());
        }
        String id = ctx.id.getText();
        System.out.println(id);
        if(ctx.returnType() != null) {
            visit(ctx.returnType());
        }
        visit(ctx.stmtBlock());
        return null;
    }

    @Override
    public Void visitStmtBlock(CarbonParser.StmtBlockContext ctx) {
        for(CarbonParser.StmtContext stmt : ctx.stmt()) {
            visit(stmt);
        }
        return null;
    }

    @Override
    public Void visitVarDecl(CarbonParser.VarDeclContext ctx) {
        String id = ctx.id.getText();
        System.out.println(id);
        visit(ctx.type());
        if(ctx.expr() != null) {
            visit(ctx.expr());
        }
        return null;
    }

    @Override
    public Void visitVarDeclStmt(CarbonParser.VarDeclStmtContext ctx) {
        visit(ctx.varDecl());
        return null;
    }

    @Override
    public Void visitAssignStmt(CarbonParser.AssignStmtContext ctx) {
        String id = ctx.id.getText();
        System.out.println(id);
        visit(ctx.expr());

        return null;
    }

    @Override
    public Void visitType(CarbonParser.TypeContext ctx) {
        switch(ctx.name.getText()) {
            case "int": break;
            case "float": break;
            case "bool": break;
            case "char": break;
            case "string": break;
        }
        return null;
    }

    @Override
    public Void visitInfixExpr(CarbonParser.InfixExprContext ctx) {
        visit(ctx.lhs);

        switch(ctx.op.getType()) {
            case CarbonParser.MUL: break;
            case CarbonParser.DIV: break;
            case CarbonParser.PLUS: break;
            case CarbonParser.MINUS: break;
        }

        visit(ctx.rhs);

        return null;
    }

    @Override
    public Void visitRelationalExpr(CarbonParser.RelationalExprContext ctx) {
        visit(ctx.lhs);

        switch(ctx.op.getType()) {
            case CarbonParser.LESS : break;
            case CarbonParser.GREATER : break;
            case CarbonParser.LESSEQ : break;
            case CarbonParser.GREATEREQ : break;
            case CarbonParser.EQ : break;
            case CarbonParser.NOTEQ : break;
        }

        visit(ctx.rhs);

        return null;
    }

    @Override
    public Void visitParenExpr(CarbonParser.ParenExprContext ctx) {
        visit(ctx.expr());
        return null;
    }

    @Override
    public Void visitPrimaryExpr(CarbonParser.PrimaryExprContext ctx) {
        visit(ctx.primary());
        return null;
    }

    @Override
    public Void visitPrimary(CarbonParser.PrimaryContext ctx) {
        System.out.println(ctx.getText());
        return null;
    }

    @Override
    public Void visitTerminal(TerminalNode node) {
        if(node.getSymbol().getType() == CarbonParser.Identifier) {
            System.out.println(node.getSymbol().getText());
        }
        return null;
    }
}
