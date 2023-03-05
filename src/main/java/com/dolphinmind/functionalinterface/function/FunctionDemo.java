package com.dolphinmind.functionalinterface.function;

import java.util.*;
import java.util.function.Function;

/**
 * 在Java8中，Function接口是一个函数接口，位于包java.util.function下.
 * Function接口定义了一个 R apply(T t)方法，它可以接受一个泛型T对象，返回一个泛型R对象
 * 即参数类型和返回类型可以不同
 */
public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println("--------------------------");
        demo1();
        System.out.println("--------------------------");
        demo2();
        System.out.println("--------------------------");
        demo3();
        System.out.println("--------------------------");
        demo4();
        System.out.println("--------------------------");
        demo5();
    }


    /**
     * 示例：输入一个字符串<T>String, 返回字符串的大写形式 <R>String
     */
    public static void demo1() {
        Function<String, String> toUpperCase = str -> str.toUpperCase();//return被省略
        String result = toUpperCase.apply("dolphinmind");
        System.out.println(result);
    }

    /**
     * 示例：输入一个字符串<T>String, 返回字符串的长度 <R> Integer
     */
    public static void demo2() {
        Function<String, Integer> lengthFunction = str -> str.length();//return被省略
        Integer length = lengthFunction.apply("dolphinmind");

        System.out.println(length);
    }

    /**
     * Function函数接口的 andThen()方法可以让多个Function函数连接使用
     */

    /**
     * 示例：输入一个字符串，获取字符串长度，然后乘上2
     */
    public static void demo3() {
        Function<String, Integer> lengthFunction = str -> str.length();
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Integer doublelength = lengthFunction.andThen(doubleFunction).apply("dolphinmind");
        System.out.println(doublelength);
    }

    /**
     * 示例：输入一个字符串List集合 <T> List<String>, 返回一个key为字符串本身， value为字符串长度的Map
     */
    public static void demo4() {
        List<String> list = Arrays.asList("java", "node", "c++", "rust", "python");

        //lambda方式
        Function<String, Integer> lengthFunction = str -> str.length();
        Map<String, Integer> listToMap1 = listToMap(list, lengthFunction);
        System.out.println(listToMap1);

        //方法引用方式
        Map<String,  Integer> listToMap2 = listToMap(list, String::length);
        System.out.println(listToMap2);

    }

    public static <T, R> Map<T, R> listToMap(List<T> list, Function<T, R> function) {
        HashMap<T, R> hashMap = new HashMap<>();
        for (T t : list) {
            hashMap.put(t, function.apply(t));
        }
        return hashMap;
    }

    /**
     * 示例：输入一个字符串 List集合 <T> List<String>, 返回大写形式的字符串List集合，返回小写形式的List集合
     */

    public static void demo5() {
        List<String> list = Arrays.asList("java", "node", "c++", "rust", "python");

        //Lambda方式
        List<String> lowerList1 = map(list, x -> x.toLowerCase());
        List<String> upperList1 = map(list, x -> x.toUpperCase());
        System.out.println("lambda方式：" + lowerList1);
        System.out.println("lambda方式：" + upperList1);

        //方法引用
        List<String> lowerList2 = map(list, String::toLowerCase);
        List<String> upperList2 = map(list, String::toUpperCase);
        System.out.println("方法引用方式：" + lowerList2);
        System.out.println("方法引用方式：" + upperList2);




    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>(list.size());
        for (T t : list) {
            resultList.add(function.apply(t));
        }

        return resultList;
    }
}
