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
package carbon.symtab;

import carbon.parsing.CarbonBaseListener;
import carbon.parsing.CarbonParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by bolte on 2/21/15.
 */
public class SymbolTableListener extends CarbonBaseListener {
    private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

    @Override
    public void enterFile(CarbonParser.FileContext ctx) {
        super.enterFile(ctx);
    }

    @Override
    public void exitFile(CarbonParser.FileContext ctx) {
        super.exitFile(ctx);
    }

    @Override
    public void enterVardecl(CarbonParser.VardeclContext ctx) {
        super.enterVardecl(ctx);
    }

    @Override
    public void exitVardecl(CarbonParser.VardeclContext ctx) {
        super.exitVardecl(ctx);
    }

    @Override
    public void enterType(CarbonParser.TypeContext ctx) {
        super.enterType(ctx);
    }

    @Override
    public void exitType(CarbonParser.TypeContext ctx) {
        super.exitType(ctx);
    }

    @Override
    public void enterPrimaryExpr(CarbonParser.PrimaryExprContext ctx) {
        super.enterPrimaryExpr(ctx);
    }

    @Override
    public void exitPrimaryExpr(CarbonParser.PrimaryExprContext ctx) {
        super.exitPrimaryExpr(ctx);
    }

    @Override
    public void enterInfixExpr(CarbonParser.InfixExprContext ctx) {
        super.enterInfixExpr(ctx);
    }

    @Override
    public void exitInfixExpr(CarbonParser.InfixExprContext ctx) {
        super.exitInfixExpr(ctx);
    }

    @Override
    public void enterPrimary(CarbonParser.PrimaryContext ctx) {
        super.enterPrimary(ctx);
    }

    @Override
    public void exitPrimary(CarbonParser.PrimaryContext ctx) {
        super.exitPrimary(ctx);
    }
}
