package arrayList;

import java.util.ArrayList;

/**
 * @Author
 * @Date 2019/10/14 11:43
 * @Version
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(10);
        list.add(2);
        list.add(null);
        System.out.println(list);
        //for each
        for (Integer a: list) {
            System.out.println(a);
        }
        list.remove(1);
        System.out.println("移除下标为1:"+list);
        System.out.println("当前数组的长度:"+list.size());

        list.trimToSize();
        System.out.println(list);

        list.clear();
        System.out.println("清空后的数组:" + list);

        MyArrayList list1 = new MyArrayList();
        list1.add("1");
        list1.add("2");
        System.out.println(list1);

    }


}
