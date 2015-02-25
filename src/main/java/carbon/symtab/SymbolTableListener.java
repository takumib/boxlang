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
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by bolte on 2/21/15.
 */
public class SymbolTableListener extends CarbonBaseListener {
    private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

    @Override
    public void exitClassImports(CarbonParser.ClassImportsContext ctx) {
        System.out.println("imported:");
        for(Iterator<TerminalNode> iter = ctx.Identifier().iterator(); iter.hasNext();) {
            System.out.println(iter.next().toString());
        }
        System.out.println();
    }

    @Override
    public void enterClassDecl(CarbonParser.ClassDeclContext ctx) {
        System.out.println("Class name: ");
        System.out.println(ctx.Identifier().toString());
        System.out.println();
    }

    @Override
    public void enterFuncDef(CarbonParser.FuncDefContext ctx) {
        System.out.println("Function name: " + ctx.Identifier().toString());
        System.out.println();
    }

    @Override
    public void exitVarDecl(CarbonParser.VarDeclContext ctx) {
        System.out.println("Variable name: " + ctx.Identifier().toString());
        System.out.println("Type: " + ctx.type().getText());
        System.out.println("Value: " + ctx.expr().getText());
        System.out.println();
    }
}
