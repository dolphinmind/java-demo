package com.dolphinmind.container.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 了解集合框架结构
 * 2. 了解Collection接口相关函数
 * 3. Collection的子接口，异同点
 * 4. 利用ArrayList实现List子接口，测试List的功能函数(增删改查)
 * 5. 集合的遍历——迭代器，While(iterable.hasNext) 与增强for循环(foreach)
 * 6. 习题演练
 * 7. 思考：泛型编程进入集合框架部分的视野越来越多，Java核心技术设计的编排有一定的道理
 */
public class ArrayListDemo {
    public static void main(String[] args) {

    }

    public static void demo1() {
        //        Collection
        List list = new ArrayList();
        list.add("Tom");
        list.add("Jerry");
        list.add(10);
        list.add(true);
        list.add(12.5);
        list.add("x");
        list.add(0x1000);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("x"));
        System.out.println(list);

        System.out.println(list.get(2));
        list.remove(3);
        System.out.println(list);
        list.set(1, "Neking");
        System.out.println(list);
        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.println(next);
//        }
        for (Object obj: list) {
            System.out.println(obj);
        }

    }}
