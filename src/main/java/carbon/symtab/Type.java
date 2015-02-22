package carbon.symtab;

/**
 * Created by bolte on 2/21/15.
 */
public abstract class Type {
    protected enum Literal {INT, FLOAT, STRING};
    protected Literal type;

    public Literal getType() {
        return type;
    }
}
