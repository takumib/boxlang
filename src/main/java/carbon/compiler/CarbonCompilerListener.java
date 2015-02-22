package carbon.compiler;

public interface CarbonCompilerListener {

    public void info(String msg);

    public void error(CarbonMessage msg);

    public void warning(CarbonMessage msg);
}
