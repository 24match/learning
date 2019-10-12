package jdk8.Lambda;

/**
 * 有参有返回值
 * @Author
 * @Date 2019/10/12 12:34
 * @Version
 */
public class Demo02 {
    public static void main(String[] args) {
        //有参无返回值
        IEat eat1 = (String thing) ->System.out.println("eat " + thing);
        eat1.eat("apple");

        //参数类型可以省略
        IEat eat2 = (thing) -> System.out.println("eat " + thing);
        eat2.eat("banana");

        //两个参数
        ISpeak speak1 = (String who,String content) -> System.out.println(who + " speak " + content);
        speak1.talk("China","helloWorld");

        //尝试省略参数类型
        ISpeak speak2 = (who,content) -> System.out.println(who + " speak " + content);
        speak2.talk("China","helloWorld");

        //有返回值
        IRun run1 = () -> {return 10;};
        run1.run();

        //返回值简写
        IRun run2 = () -> 10;
        System.out.println("跑100米速度为:"+run2.run()+"s");
    }
}

interface IEat {
    void eat(String thing);
}

interface ISpeak {
    void talk(String who , String content);
}

interface IRun {
    int run();
}