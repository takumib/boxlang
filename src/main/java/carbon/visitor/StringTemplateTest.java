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
package carbon.visitor;

import carbon.parsing.CarbonBaseVisitor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author bolte
 *
 * A pretty print visitor for Carbon.
 *
 */
public class StringTemplateTest extends CarbonBaseVisitor<ST> {
    public StringTemplateTest() {
        STGroupFile f = new STGroupFile("carbon/templates/visitor/hello.stg");
        ST hello = f.getInstanceOf("decl");
        hello.add("type", "int");
        hello.add("name", "x");
        hello.add("value", 0);
        System.out.println(hello.render());

        ST st = new ST("<items:{it | <it.id>: <it.lastName>, <it.firstName>\n}>");
        st.addAggr("items.{firstName, lastName, id}", "Takumi", "Bolte", "tbolte");
        System.out.println(st.render());

        ST st2 = new ST("<[\"a\",\"b\"]:{v | <v> = <i>; }>");
        System.out.println(st2.render());

        int[] a = { 3,9,20,2,1,4,6,32,5,6,77,888,
                2,1,6,32,5,6,77,4,9,20,2,1,4,63,9,20,2,1,
                4,6,32,5,6,77,6,32,5,6,77,3,9,20,2,1,4,6,
                32,5,6,77,888,1,6,32,5 };

        ST starr = new ST("int[] a = { <values; wrap, anchor, separator=\",\">};");
        starr.add("values", a);
        System.out.println(starr.render(40));
    }

    public static void main(String[] args) {
        new StringTemplateTest();
    }
}
