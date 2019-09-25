package design.serviceLocatorPattern;

/**
 * 服务定位器模式
 * 为 JNDI 查询创建 InitialContext。
 */
public class InitialContext {

    public Object lookUp(String jndiName){
        if (jndiName.equalsIgnoreCase("SERVICE1")){
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1();
        } else if (jndiName.equalsIgnoreCase("SERVICE2")){
            System.out.println("Looking up and creating a new Service2 object");
            return new Service2();
        }
        return null;
    }

}
