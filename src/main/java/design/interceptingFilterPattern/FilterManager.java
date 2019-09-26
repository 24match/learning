package design.interceptingFilterPattern;

/**
 * 创建过滤管理器。
 * 过滤管理器（Filter Manager） - 过滤管理器管理过滤器和过滤器链。
 */
public class FilterManager {

    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        System.out.println("filter manager filterRequest");
        filterChain.execute(request);
    }
}
