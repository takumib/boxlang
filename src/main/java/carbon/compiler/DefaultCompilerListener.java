package carbon.compiler;

public class DefaultCompilerListener implements CarbonCompilerListener {

    private final CarbonCompiler compiler;

    public DefaultCompilerListener(CarbonCompiler c) {
        this.compiler = c;
    }

    @Override
    public void error(CarbonMessage m) {

    }

    @Override
    public void info(String msg) {
        if (compiler.errorManager.formatWantsSingleLineMessage()) {
            msg = msg.replace('\n', ' ');
        }
        System.out.println(msg);
    }

    @Override
    public void warning(CarbonMessage msg) {

    }
}
