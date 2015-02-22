package carbon.symtab;

import java.util.HashMap;
import carbon.symtab.Type;
import carbon.symtab.Literal;

/**
 * Created by bolte on 2/21/15.
 */
public class SymbolTable {
    private HashMap<String, Literal> symtab;

    public SymbolTable() {
        symtab = new HashMap<String, Literal>();
    }

    public void put(String identifier, Literal literal) {
        symtab.put(identifier, literal);
    }

    public Literal get(String identifier) {
       return symtab.get(identifier);
    }
}
