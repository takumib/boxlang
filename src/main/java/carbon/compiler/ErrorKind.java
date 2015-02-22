package carbon.compiler;

import org.antlr.v4.tool.ErrorSeverity;

public enum ErrorKind {

    /**
     * <p>Compiler error 1: cannot write file <em>filename</em>:
     * <em>reason</em></p>
     */
    CANNOT_WRITE_FILE(1, "cannot write file <arg>: <arg2>",
            ErrorSeverity.ERROR),

    /**
     * <p>Compiler error 2: cannot find or open file: <em>filename</em></p>
     */
    CANNOT_OPEN_FILE(2, "cannot find or open file: <arg>"
            + "<if(exception&&verbose)>; reason: <exception><endif>",
            ErrorSeverity.ERROR);

    public final int code;
    public final String message;

    public final ErrorSeverity severity;

    ErrorKind(int code, String message, ErrorSeverity severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }
}
