package charactor;

public class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;

    /**
     * 1.无论通过什么途径获取类对象,会导致静态属性被初始化,只会执行一次
     */
    static String copyright;

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }

}
