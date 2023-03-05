package com.dolphinmind.functionalinterface.unaryoperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * unary：一元的; unary operator 一元操作符
 *
 * 参考文档：
 * 1. https://www.wdbyte.com/java8/java8-unaryoperaotr/#_1-unaryoperator
 */
public class UnaryOperatorDemo {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        demo1();
        System.out.println("-------------------------");
        demo2();
        System.out.println("-------------------------");
        demo3();
        System.out.println("-------------------------");
        demo4();
    }

    /**
     * 示例：分别使用UnaryOperator和Function把字符串转换为大写形式
     */
    public static void demo1() {
        Function<String, String> upperFun1 = s -> s.toUpperCase();
        UnaryOperator<String> upperFun2 = s -> s.toUpperCase();

        String res1 = upperFun1.apply("dolphinmind");
        String res2 = upperFun2.apply("dolphinmind");

        System.out.println(res1);
        System.out.println(res2);

    }

    /**
     * 示例：把字符串集合转换成key为大写字符串，value为字符串本身的Map（使用identity()方法返回本身）
     */
    public static void demo2() {
        Function<String, String> upperFun1 = s -> s.toUpperCase();
        UnaryOperator<String> upperFun2 = s -> s.toUpperCase();

        List<String> list = Arrays.asList("java", "node", "c++", "rust", "python");

        Map<String, String> map1 = list.stream()
                .collect(Collectors.toMap(upperFun1::apply, Function.identity()));

        Map<String, String> map2 = list.stream()
                .collect(Collectors.toMap(upperFun2::apply, UnaryOperator.identity()));

        Map<String, String> map3 = list.stream()
                .collect(Collectors.toMap(upperFun2::apply, t -> t));

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
    }

    /**
     * 示例：使用UnaryOperator()作为参数，修改List集合中的每个元素
     */
    public static void demo3() {
        List<String> list = Arrays.asList("java", "node", "c++", "rust", "python");
        UnaryOperator<String> upperFun = s -> s.toUpperCase();
        List<String> resultList = map(list, upperFun);
        System.out.println(resultList);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        UnaryOperator<Integer> doubleInt = i -> i * 2;
        List<Integer> integers = map(intList, doubleInt);
        System.out.println(integers);
    }

    public static <T> List<T> map(List<T> list, UnaryOperator<T> unaryOperator) {
        List<T> resultList = new ArrayList<>();
        for(T t : list) {
            resultList.add(unaryOperator.apply(t));
        }
        return resultList;
    }

    /**
     * 示例：使用UnaryOperator作为参数，修改List集合中的每个元素，先转大写，再截取前三位
     */
    public static void demo4() {
        List<String> list = Arrays.asList("java", "node", "c++", "rust", "python");
        UnaryOperator<String> upperFun = s -> s.toUpperCase();//将元素转换为大写
        UnaryOperator<String> subFun = s -> s.substring(0,3);//截取字符串的前三位

        List<String> resultList = map(list, upperFun, subFun);
        System.out.println(resultList);
    }

    public static <T> List<T> map(List<T> list, UnaryOperator<T>... unaryOperators) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            for (UnaryOperator<T> operator : unaryOperators) {
                t = operator.apply(t);
            }
            resultList.add(t);
        }
        return resultList;
    }
}
