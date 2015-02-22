package carbon.symtab;

/**
 * Created by bolte on 2/21/15.
 */
public class StringLiteral implements Literal {
    private String val;
    private Type type;

    public StringLiteral(String val) {
        this.val = val;
        type = new StringType();
    }

    public Type getType() {
        return type;
    }
}
