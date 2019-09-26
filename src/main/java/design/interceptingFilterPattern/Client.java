package design.interceptingFilterPattern;

/**
 * 客户端（Client） - Client 是向 Target 对象发送请求的对象。
 */
public class Client {

    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        System.out.println("set FilterManager");
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        System.out.println("Client setRequest");
        filterManager.filterRequest(request);
    }
}
