package jdk8.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * List.sort()排序实战
 * @Author
 * @Date 2019/10/12 14:08
 * @Version
 */
public class Demo05 {

    public static void main(String[] args) {
        // List.sort() 排序
        List<Person> list = new ArrayList<>();
        list.add(new Person(3));
        list.add(new Person(1));
        list.add(new Person(8));
        list.add(new Person(7));
        list.add(new Person(5));
        // 1.传统方式使用 - 升序
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // o1和o2比较 1:大于 0:相等 -1:小于
                // 颠倒结果就是降序
                return o1.getHeight().compareTo(o2.getHeight());
            }
        });
        // 2.Lambda使用 - 升序
        list.sort(Comparator.comparing(Person::getHeight));
        // 打印结果
        for (Person person : list) {
            System.out.println(person.getHeight());
        }
    }
}

class Person {
    private Integer height;

    public Person(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
