package com.dolphinmind.functionalinterface.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 参考文档
 * 1. https://www.cnblogs.com/qdhxhz/p/11323595.html
 */

public class PredicateDemo {
    public static void main(String[] args) {
        System.out.println("----------------------");
        demo1();
        System.out.println("----------------------");
        demo2();
        System.out.println("----------------------");
        demo3();
        System.out.println("----------------------");
        demo4();

    }

    /** 1. Predicate接口的使用
     *  常规示例1:判断数字是否大于7
     */
    public static void demo1() {
        Predicate<Integer> predicate = x -> x > 7; //设置一个大于7的过滤条件，传递lambda表达式
        System.out.println("判断："+predicate.test(10));
        System.out.println("判断："+predicate.test(4));
    }

    /**
     * 常规示例2：大于7且为偶数
     */
    public static void demo2() {
        Predicate<Integer> predicate = x -> x > 7;
        //在上面大于7的条件下，添加是偶数的条件
        predicate = predicate.and(x -> x % 2 == 0);
        System.out.println("判断："+predicate.test(12));
        System.out.println("判断："+predicate.test(23));
        System.out.println("判断："+predicate.test(1));
    }

    /**
     * 常规示例3
     */
    public static void demo3() {
        Predicate<Integer> predicate = x -> x > 5 && x < 9;
        System.out.println("判断："+predicate.test(10));
        System.out.println("判断："+predicate.test(6));
    }

    /**
     * 集合Stream示例
     */
    public static void demo4() {
        User user1 = new User("杀生丸", "男",24);
        User user2 = new User("犬夜叉", "男",20);
        User user3 = new User("桔梗", "女",18);
        User user4= new User("珊瑚", "女",21);
        User user5 = new User("米勒", "男",22);
        User user6 = new User("米勒", "男",22);
        User user7 = new User("珊瑚", "女",21);
        User user8 = new User("米勒", "男",22);

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);

        //1. 获取年龄大于20的对象
        List<User> collect1 = users.stream()
                                  .filter(x -> x.getAge() > 20).collect(Collectors.toList());
        System.out.println("获取年龄大于22的人物数量" + collect1.size());

        //2. 去重，设置name相同即为相同对象
        //方式1，直接使用distinct
        List<User> collect2 = users.stream().distinct().collect(Collectors.toList());
        System.out.println("输出剩余对象：" + collect2.size());

        //3. 从集合中找出与该队象相同的元素，通用name相同即为相同对象
        User usertest = new User("珊瑚", "女",21);
        Predicate<User> predicate = Predicate.isEqual(usertest);
        List<User> collect3 = users.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("输出过滤后的对象个数" + collect3.size());

    }
}
