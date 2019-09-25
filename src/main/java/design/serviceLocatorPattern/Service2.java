package design.serviceLocatorPattern;

/**
 * 服务定位器模式
 * 创建实体服务2
 */
public class Service2 implements Service{

    public String getName() {
        return "Service2";
    }

    public void excute() {
        System.out.println("Execute Service2");
    }
}
