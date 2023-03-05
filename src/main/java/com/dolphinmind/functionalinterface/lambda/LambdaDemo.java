package com.dolphinmind.functionalinterface.lambda;


import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

/**
 * 函数式编程的思维，跟面向对象的编程思维不同，前者只关注数据的输入输出，操作当作黑盒
 * 参考链接：https://www.bilibili.com/video/BV1Gh41187uR/?spm_id_from=333.999.0.0&vd_source=94b4b172863c73665f9cb7dba77ea0db
 */
public class LambdaDemo {
    public static void main(String[] args) {
        AnonymityClass2Lambda();
        demo1();
        demo3();
    }

    /**
     *  匿名内部类与Lambda函数
     *  alt + enter 匿名内部类与lambda表达式之间的转换
     */
    public static void AnonymityClass2Lambda() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过匿名内部类，线程被创建了！");
            }
        }).start();

        new Thread(() -> {
            System.out.println("通过Lambda函数, 线程被创建了！");
        }).start();

        System.out.println("Lambda表达式显得更为简介！");
    }

    /** 分析
     *  参数为接口类型，函数体对接口中的函数进行调用
     *  匿名内部类或lambda主要实现了接口的功能函数
     */
    public static  void demo1() {
        int num1 = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println("通过创建IntBinaryOperator()匿名内部类返回两数之和：" + num1);

        int num2 = calculateNum(((left, right) -> {
            return left + right;
        }));

    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    /**
    public static void demo2() {
        printNum(value -> {
            if(value < 0) return false;
            return
                     value % 2 != 0;
        });
    }

    //这样书写其实并不是很好
    public static void printNum(IntPredicate predicate) {
        int[] arr = {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i:arr) {
            if(predicate.test(i)){
                System.out.print(i + "  ");
            }
        }
    }
     */
    public static void demo3() {
        int[] arr = {-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Predicate<Integer> predicate = PredicateRules();
        System.out.print("输出过滤后的结果： ");
        for(int item : arr) {
            if(predicate.test(item)){
                System.out.print(item + "\t");
            }
        }
    }
    public static Predicate<Integer> PredicateRules() {
        Predicate<Integer> predicate = value -> {
            if(value < 0) return false;
            return value % 2 != 0;
        };
        return predicate;
    }
}
