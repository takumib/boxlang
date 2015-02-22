package carbon.compiler;

import carbon.parsing.CarbonLexer;
import carbon.parsing.CarbonParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by bolte on 2/21/15.
 */
public class CarbonCompiler {
    public static void main(String[] args) {
        try {
            ANTLRInputStream input = new ANTLRFileStream(args[0]);
            CarbonLexer lexer = new CarbonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CarbonParser parser = new CarbonParser(tokens);
            ParseTree tree = parser.file();
            ParseTreeWalker walker = new ParseTreeWalker();

            //System.out.println(tree.getText());

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
