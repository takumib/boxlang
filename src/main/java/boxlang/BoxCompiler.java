package boxlang;

import boxlang.parsing.BoxLexer;
import boxlang.parsing.BoxParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by bolte on 2/21/15.
 */
public class BoxCompiler {
    public static void main(String[] args) {
        try {

            ANTLRInputStream input = new ANTLRFileStream(args[0]);
            BoxLexer lexer = new BoxLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BoxParser parser = new BoxParser(tokens);
            ParseTree tree = parser.file();
            ParseTreeWalker walker = new ParseTreeWalker();

            //System.out.println(tree.getText());

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
