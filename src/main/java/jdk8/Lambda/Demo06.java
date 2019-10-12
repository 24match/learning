package jdk8.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤指定元素实战
 * @Author
 * @Date 2019/10/12 14:21
 * @Version
 */
public class Demo06 {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People("zs",22));
        list.add(new People("ls",27));
        list.add(new People("ww",29));
        list.add(new People("zl",21));
        // 集合遍历查找 年龄在20-25岁的人
        List<People> search = new ArrayList<>();
        // 传统方式
        for (People people : list) {
            if (people.getAge() >= 20 && people.getAge() <= 25){
                search.add(people);
            }
        }

        // lambda
        // Stream是Java 8 提供的高效操作集合类（Collection）数据的API。
        search = list.stream().filter((People people) -> people.getAge() >= 20 && people.getAge() <= 25).collect(Collectors.toList());
        for (People people : search) {
            System.out.println(people.getName() + "-" + people.getAge());
        }
    }
}

class People {

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
