package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //加载xml配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\LontranxWorkspaceIDEA\\spring\\src\\main\\java\\Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

    }


}
