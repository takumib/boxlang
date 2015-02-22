package carbon.compiler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorManager extends BaseErrorListener {

    private final CarbonCompiler compiler;

    private int errorCount, warningCount;

    public ErrorManager(CarbonCompiler c) {
        this.compiler = c;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg,
                            RecognitionException e) {
    }

    public void toolError(ErrorKind kind, String msg) {

    }

    public boolean formatWantsSingleLineMessage() {
        return false;
    }

    //public void semanticError()
}
