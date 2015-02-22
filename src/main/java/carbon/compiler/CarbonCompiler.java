package carbon.compiler;

import carbon.parsing.CarbonLexer;
import carbon.parsing.CarbonParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarbonCompiler {

    public static String VERSION = "2.22.15a";

    public final ErrorManager errorManager;
    public final String[] args;

    public boolean helpFlag = false;

    public final DefaultCompilerListener defaultListener =
            new DefaultCompilerListener(this);

    public final List<String> targetFiles = new ArrayList<String>();

    public CarbonCompiler(String[] args) {
        this.errorManager = new ErrorManager(this);
        this.args = args;
        handleArgs();
    }

    public void handleArgs() {
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                if (!targetFiles.contains(arg)) {
                    targetFiles.add(arg);
                }
            }
        }
    }

    public void processCommandLineTargets() {
        List<ParseTree> targets = getTrees();

        //analysis here.
    }

    public List<ParseTree> getTrees() {
        List<ParseTree> roots = new ArrayList<ParseTree>();
        for (String fileName : targetFiles) {
            try {
                File file = new File(fileName);
                if (!file.isAbsolute()) {
                    file = new File(System.getProperty("user.dir"), fileName);
                }
                ANTLRFileStream input =
                        new ANTLRFileStream(file.getAbsolutePath());
                CarbonLexer lexer = new CarbonLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CarbonParser parser = new CarbonParser(tokens);
                roots.add(parser.file());
            }
            catch (IOException ioe) {
                //errorManager.toolError(ErrorKind.CANNOT_OPEN_FILE, "");
                throw new RuntimeException(ioe);
            }
        }
        return roots;
    }

    public void log(String msg) {
    }

    public static void main(String[] args) {
        CarbonCompiler carbon = new CarbonCompiler(args);

        if (args.length == 0) {
            carbon.help();
            carbon.exit(0);
        }
        carbon.processCommandLineTargets();

        if (carbon.errorManager.getErrorCount() > 0) {
            carbon.exit(1);
        }
    }

    public void help() {
        info("Carbon Compiler Version " + VERSION);
    }

    public void info(String msg) {
        defaultListener.info(msg);
    }

    public void exit(int e) {
        System.exit(e);
    }
}
