package carbon.symtab;

import carbon.symtab.Literal;
import carbon.symtab.Type;
import carbon.symtab.FloatType;

/**
 * Created by bolte on 2/21/15.
 */
public class FloatLiteral implements Literal {
    private float val;
    private Type type;

    public FloatLiteral(float val) {
        this.val = val;
        type = new FloatType();
    }

    public Type getType() {
        return type;
    }
}
