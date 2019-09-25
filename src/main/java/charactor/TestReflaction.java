package charactor;

/**
 * 反射
 * 1.无论通过什么途径获取类对象,会导致静态属性被初始化,只会执行一次
 */
public class TestReflaction {
    public static void main(String[] args) {

        //获取类对象的三种方式
        String className = "charactor.Hero";
        try {
            //1
            Class pClass1 = Class.forName(className);
            //2
            Class pClass2 = charactor.Hero.class;
            //3
            Class pClass3 = new charactor.Hero().getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
