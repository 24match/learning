package jdk8.Lambda;

/**
 * final类型参数
 * @Author
 * @Date 2019/10/12 12:45
 * @Version
 */
public class Demo03 {

    public static void main(String[] args) {
        //全写
        IAdditon additon1 = (final int a , final int b) -> a+b;
        System.out.println(additon1.add(1,2));

        //隐藏参数类型
        IAdditon additon2 = (a,b) -> a+b;
        System.out.println(additon2.add(1,3));
    }
}

interface IAdditon {
    int add(final int a,final int b);
}
