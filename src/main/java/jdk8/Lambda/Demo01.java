package jdk8.Lambda;

/**
 * 无参无返回值
 * @Author
 * @Date 2019/10/12 12:18
 * @Version
 */
public class Demo01 {

    public static void main(String[] args) {
        //传统方式使用
        ICar car1 = new IcarImpl();
        car1.drive();

        //匿名内部类使用
        ICar car2 = () -> System.out.println("Drive BMW");
        car2.drive();

        ICar car3 = () -> System.out.println("Drive Audi");
        car3.drive();

        ICar car4 = () -> System.out.println("Drive Ferrari");
        car4.drive();
    }
}

interface ICar {
    void drive();
}

class IcarImpl implements ICar {

    @Override
    public void drive() {
        System.out.println("Drive Benz");
    }
}
