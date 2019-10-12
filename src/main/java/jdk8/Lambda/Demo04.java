package jdk8.Lambda;

/**
 * 线程实战
 * @Author
 * @Date 2019/10/12 12:50
 * @Version
 */
public class Demo04 {
    public static void main(String[] args) {
        //传统方式创建线程
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        //匿名内部类使用
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 is running...");
            }
        });
        t2.start();

        //lambada 使用
        Thread t3 = new Thread(() -> System.out.println("t3 is running..."));
        t3.start();
        //更简的写法
        new Thread(() -> System.out.println("t4 is running...")).start();
        //更简的写法2
        Process.process(() -> System.out.println("t5 is running..."));
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("线程t1 is running.....");
    }
}

interface Process {
    // Java8中允许接口中定义非抽象方法 前提该方法必须为 default 或 static
    static void process (Runnable runnable) {
        new Thread(runnable).start();
    }
}