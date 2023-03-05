package com.dolphinmind.functionalinterface.comsumer;

import java.util.function.Consumer;

/**
 * 参考文档链接：
 * 1. https://www.cnblogs.com/qdhxhz/p/12050701.html
 * 2. https://www.wdbyte.com/java8/java8-unaryoperaotr/#_1-unaryoperator
 * 3. https://www.cnblogs.com/qdhxhz/p/11323595.html
 * 4. https://www.cnblogs.com/9dragon/p/10901448.html
 *
 */

@SuppressWarnings({"all"})
public class ComsumerDemo {
    public static void main(String[] args) {
        getSquare();
        testAndThen();
        demo1();
        demo2();
    }

    /** 1. Consumer接口的使用
     * 简单的平方计算
     */
    public static void getSquare() {
        Consumer<Integer> square = x -> System.out.println("平方计算：" + x * x);
        square.accept(2);
    }

    /**
     * 定义3个Consumer并按顺序调用andThen(方法)
     */
    public static void testAndThen() {
        Consumer<Integer> consumer1 = x -> System.out.println("当前值：" + x);
        Consumer<Integer> consumer2 = x -> System.out.println("相加：" + (x + x));
        Consumer<Integer> consumer3 = x -> System.out.println("相乘：" + (x * x));
        consumer1.andThen(consumer2).andThen(consumer3).accept(3);
        //先输出3 ,后将3传递给consumer2进行相加，接着将3传递给consumer3进行相乘
    }

    /**
     * StringBuider 连接字符串
     */
    public static  void demo1() {
        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> consumer = str -> str.append("Jack");
        consumer.accept(sb);
        System.out.println(sb.toString());
    }

    public static void demo2() {
        StringBuilder sb = new StringBuilder("Hello ");
        Consumer<StringBuilder> consumer1 = str -> str.append("Jack! ");
        Consumer<StringBuilder> consumer2 = str -> str.append("Bob! ");
        Consumer<StringBuilder> consumer3 = str -> str.append("Neking! ");
        consumer1.andThen(consumer2).andThen(consumer3).accept(sb); //先执行consumer1 后面根据andThen进行依次执行
        //Hello Jack! -> Hello Jack! Bob! -> Hello Jack! Bob! Neking!
        System.out.println(sb.toString());
    }

}
