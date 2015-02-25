package carbon.symtab;

import carbon.parsing.CarbonBaseListener;
import carbon.parsing.CarbonParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by bolte on 2/21/15.
 */
public class SymbolTableListener extends CarbonBaseListener {
    private ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

    @Override
    public void enterFile(CarbonParser.FileContext ctx) {
        super.enterFile(ctx);
    }

    @Override
    public void exitFile(CarbonParser.FileContext ctx) {
        super.exitFile(ctx);
    }

    @Override
    public void enterVardecl(CarbonParser.VardeclContext ctx) {
        super.enterVardecl(ctx);
    }

    @Override
    public void exitVardecl(CarbonParser.VardeclContext ctx) {
        super.exitVardecl(ctx);
    }

    @Override
    public void enterType(CarbonParser.TypeContext ctx) {
        super.enterType(ctx);
    }

    @Override
    public void exitType(CarbonParser.TypeContext ctx) {
        super.exitType(ctx);
    }

    @Override
    public void enterPrimaryExpr(CarbonParser.PrimaryExprContext ctx) {
        super.enterPrimaryExpr(ctx);
    }

    @Override
    public void exitPrimaryExpr(CarbonParser.PrimaryExprContext ctx) {
        super.exitPrimaryExpr(ctx);
    }

    @Override
    public void enterInfixExpr(CarbonParser.InfixExprContext ctx) {
        super.enterInfixExpr(ctx);
    }

    @Override
    public void exitInfixExpr(CarbonParser.InfixExprContext ctx) {
        super.exitInfixExpr(ctx);
    }

    @Override
    public void enterPrimary(CarbonParser.PrimaryContext ctx) {
        super.enterPrimary(ctx);
    }

    @Override
    public void exitPrimary(CarbonParser.PrimaryContext ctx) {
        super.exitPrimary(ctx);
    }
}
