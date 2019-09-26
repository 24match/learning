package design.interceptingFilterPattern;

/**
 * 实体过滤器
 */
public class DebugFilter implements Filter{

    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}
