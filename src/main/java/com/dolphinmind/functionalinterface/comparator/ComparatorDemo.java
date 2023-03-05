package com.dolphinmind.functionalinterface.comparator;


import java.util.*;

/**
 * 利用Lambda和Comparator接口实现List的排序功能
 */

public class ComparatorDemo {
    public static void main(String[] args) {
        System.out.println("-------------------");
        demo1();
        System.out.println("-------------------");
        demo2();
        System.out.println("-------------------");
        demo3();
    }

    public static List<User> createList() {
        List<User> list = new ArrayList<>();
        list.add(new User("路飞", "男", 17));
        list.add(new User("索隆", "男", 18));
        list.add(new User("山治", "男", 18));
        list.add(new User("娜美", "女", 16));
        list.add(new User("乌索普", "男", 19));
        list.add(new User("乔巴", "男", 6));
        list.add(new User("甚平", "男", 26));
        list.add(new User("弗兰奇", "男", 22));
        return list;
    }

    /**
     * Comparator是Java8之前常用的排序方式
     */
    public static void demo1() {
        List<User> list = createList();
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (User user : list) {
            System.out.println("名称："+user.getName() + " 年龄：" + user.getAge());
        }
    }

    /**
     * Lambda和Comparator排序
     */
    @SuppressWarnings({"all"})
    public static void demo2() {
        List<User> list = createList();
        sort1(list);
        for (User user : list) {
            System.out.println("名称："+user.getName() + " 年龄：" + user.getAge());
        }
    }

    public static List<User> sort1(List<User> list) {
        Comparator<User> byAge = (User o1, User o2) -> o1.getAge().compareTo(o2.getAge());
        list.sort(byAge);
        return list;
    }

    public static void demo3() {
        List<User> list = createList();
        sort2(list);
        for (User user : list) {
            System.out.println("名称："+user.getName() + " 年龄：" + user.getAge());
        }
    }

    public static List<User> sort2(List<User> list) {
//        Comparator<User> byAge = Comparator.comparing(User::getAge);
//        list.sort(byAge);
        list.sort(Comparator.comparing(User::getAge));
        return list;
    }
}
