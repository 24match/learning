package spring.tutorialspoint;

/**
 * Spring
 */
public class HelloWorld {
    //1.beanFactory容器
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Your Message : " + message);//message beans里面传的value值
    }


    //2.Spring Bean 定义继承
    private String message1;
    private String message2;

    public void getMessage1() {
        System.out.println("World Message1 : " + message1);//message2 就是配置文件beans2里面的value
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void getMessage2() {
        System.out.println("World Message2 : " + message2);//message2 就是配置文件beans2里面的value
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}
