package spring.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1.加载xml配置文件

        ApplicationContext context1 = new FileSystemXmlApplicationContext("D:\\LontranxWorkspaceIDEA\\learning\\src\\main\\java\\Beans1.xml");
        HelloWorld obj = (HelloWorld) context1.getBean("helloWorld");
        obj.getMessage();

        ApplicationContext context2 = new FileSystemXmlApplicationContext("D:\\LontranxWorkspaceIDEA\\learning\\src\\main\\java\\Beans2.xml");

        HelloWorld objA = (HelloWorld) context2.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();

        HelloIndia objB = (HelloIndia) context2.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();//在bean中没有定义message3的值,但是在helloWorld的bean中有定义,并直接输出了message2的信息,bean的定义继承
        objB.getMessage3();

        TextEditor textEditor = (TextEditor) context2.getBean("textEditor");
        textEditor.spellCheck();

    }
}
