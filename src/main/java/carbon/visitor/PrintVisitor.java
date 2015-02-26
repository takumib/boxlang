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
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author bolte
 *
 * This is a print visitor for Carbon.
 */
public class PrintVisitor extends CarbonBaseVisitor {

    public PrintVisitor() {
        STGroupFile f = new STGroupFile("main/resources/carbon/templates/visitor/print.stg");
        ST var = f.getInstanceOf("vardecl");
        var.add("name", "x");
        var.add("type", "int");
        var.add("value", 0);
        System.out.println("variable declaration:");
        System.out.println(var.render());

        System.out.println();

        ST func = f.getInstanceOf("funcdecl");
        func.add("modifier", "private");
        func.add("name", "foo");
        func.add("ret", "int");
        System.out.println("function declaration:");
        System.out.println(func.render());

        System.out.println();

        ST funcdef = f.getInstanceOf("funcdef");
        funcdef.add("modifier", "private");
        funcdef.add("name", "foo");
        funcdef.add("ret", "int");
        funcdef.add("stmts", "print x;");
        funcdef.add("stmts", "print y;");
        System.out.println("function definition:");
        System.out.println(funcdef.render());

        System.out.println();

        ST classdecl = f.getInstanceOf("classdecl");
        classdecl.add("imports", "std");
        classdecl.add("imports", "foo, bar");
        classdecl.add("modifier", "private");
        classdecl.add("name", "Foo");
        System.out.println("class declaration:");
        System.out.println(classdecl.render());
    }

    public static void main(String[] args) {
        new PrintVisitor();
    }
}
