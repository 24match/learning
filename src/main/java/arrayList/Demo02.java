package arrayList;

/**
 * @Author
 * @Date 2019/10/14 12:31
 * @Version
 */
public class Demo02 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("1");
        list.add("3");
        System.out.println(list);

        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(1);
        System.out.println(list1.toString());

    }
}
