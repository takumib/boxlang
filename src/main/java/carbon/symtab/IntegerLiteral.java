package carbon.symtab;

import carbon.symtab.Literal;
import carbon.symtab.Type;
import carbon.symtab.IntegerType;

/**
 * Created by bolte on 2/21/15.
 */
public class IntegerLiteral implements Literal {
    private int val;
    Type type;

    public IntegerLiteral(int val) {
        this.val = val;
        type = new IntegerType();
    }

    public Type getType() {
        return type;
    }

    public int getVal() {
        return val;
    }
}
