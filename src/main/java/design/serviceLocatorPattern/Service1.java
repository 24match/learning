package design.serviceLocatorPattern;

/**
 * 服务定位器模式
 * 创建实体服务1
 */
public class Service1 implements Service{

    public String getName() {
        return "Service1";
    }

    public void excute() {
        System.out.println("Executing Service1");
    }
}
