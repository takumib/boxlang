package carbon.compiler;

import org.antlr.v4.runtime.Token;

public class LanguageSemanticsMessage extends CarbonMessage {

    public LanguageSemanticsMessage(ErrorKind etype, String fileName,
                                   Token offendingToken, Object... args) {
        super(etype,offendingToken,args);
        this.fileName = fileName;
        if ( offendingToken!=null ) {
            line = offendingToken.getLine();
            charPosition = offendingToken.getCharPositionInLine();
        }
    }
}
