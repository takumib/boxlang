package carbon.compiler;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

public class LanguageSyntaxMessage extends CarbonMessage {

    public LanguageSyntaxMessage(ErrorKind etype,
                                Token offendingToken,
                                RecognitionException antlrException,
                                Object... args) {
        super(etype, antlrException, offendingToken, args);
        this.offendingToken = offendingToken;
        if ( offendingToken!=null ) {
            this.fileName = offendingToken.getTokenSource().getSourceName();
            this.line = offendingToken.getLine();
            this.charPosition = offendingToken.getCharPositionInLine();
        }
    }

    @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"})
    @Override
    public RecognitionException getCause() {
        return (RecognitionException)super.getCause();
    }
}
