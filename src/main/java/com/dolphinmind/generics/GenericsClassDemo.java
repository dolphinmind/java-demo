package com.dolphinmind.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一、泛型的概念
 * 1. Java泛型(generics)是JDK5中引入的一个新特性，泛型提供了编译时类型安全检测机制,
 * 该机制允许我们在编译时检测到非法的类型数据结构
 * 2. 泛型的本质是形式参数，也就是所操作的数据类型被指定为一个参数
 *
 * 二、泛型的好处
 * 1. 类型安全
 * 2. 消除强制类型的转换
 *
 * 三、泛型类(类似于普通类的工厂)
 * 1. 定义语法
 *     Class 类名称 <泛型标识, 泛型标识, ...> {
 *         private 泛型标志 变量名;
 *     }
 * 2. 常用的泛型标识
 *    T、E、(K、V)
 *    T、U、S表示任意类型
 *    E表示集合的元素类型
 *    K、V表示键值对类型
 *
 * 四、小结
 * 1. 泛型类，若没有指定具体的数据类型，此时操作类型是Object
 * 2. 泛型的类型参数只能是类类型，不能是基本数据类型
 * 3. 泛型类，类型在逻辑上可看成是多个不同的类型，但实际上都是相同类型(通过反射得知)
 *
 * 五、 泛型函数
 *  1. 泛型方法可在普通类定义，也可在泛型类中定义
 *  2. 结构
 *  class UsualClass {
 *      public static <T> T functionname(T... args) {
 *
 *      }
 *  }
 *      <T> T 返回类型，也可以变成 <V> ClassName<V, R> 类类型返回，参考lambda中的Function接口
 *   3. 泛型函数调用：UsuaClass.<T>functionname(T... args), 其中的T 和 args都需要替换成实参数类型，functionname前面的<T>可以省略掉
 */
public class GenericsClassDemo {
    public static void main(String[] args) {
//        System.out.println("----------------------");
//        demo1();
//        System.out.println("----------------------");
//        demo2();
//        System.out.println("----------------------");
//        demo3();
//        System.out.println("----------------------");
//        demo4();
        System.out.println("----------------------");
        demo5();
    }

    /**
     * 1. 创建了一个能够接收任何类型数据的泛型类，并进行输出
     *
     * 从输出结果可以看出泛型类的优秀之处，提升了代码的复用度
     */
    @SuppressWarnings({"all"})
    public static void demo1() {
        GenericsClass<String> dolphinmind = new GenericsClass<>("Dolphinmind");
        GenericsClass<Integer> integerGenericsClass = new GenericsClass<>(10);
        GenericsClass<Object> objectGenericsClass = new GenericsClass<>(null);

        System.out.println(dolphinmind.getData());
        System.out.println(integerGenericsClass.getData());
        System.out.println(objectGenericsClass.getData());
    }


    /**
     * 2. 创建一个泛型方法
     */
    public static void demo2() {
        GenericsMehtodDemo genericsMehtodDemo = new GenericsMehtodDemo();
        genericsMehtodDemo.<Boolean>genericMethod(true);
        genericsMehtodDemo.<String>genericMethod("Java Programming");

        System.out.println(GenericsClassDemo.genericsmethod(20.0, 30, "40"));

    }

    @SafeVarargs
    public static <T> T genericsmethod(T... args) {
        return args[args.length / 2];
    }

    /**
     * 测试泛型的限制和局限性
     *
     */
    public static void demo3() {
        Apple apple = new Apple();
        Apple[] apples = new Apple[10];

        Pair<String> stringPair = new Pair<>();
        //new Pair<String>[10] error


    }

    public static void demo4() {
        Eater eater = new Eater();

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Apple());
        foodList.add(new Fruit());
        eater.eat(foodList);

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Apple());
        fruitList.add(new Fruit());
        eater.eat(fruitList);
    }

    /**
     * 泛型与数组
     * 1. 泛型数组的创建
     *    a. 可声明带泛型的数组引用，但是不能直接创建带泛型的数组对象
     *    b. 可通过java.lang.reflect.Array的newInstance(Class<T>, int) 创建T[]数组
     * 2. 小结
     *    在实际开发过程中，尽量使用泛型集合去替代泛型数组
     */

    //demo5里面的东西有点绕，从数组衍生到泛型数组，将普通数组的引用给予泛型数组引用，可访问同一地址中的元素，
    // 在取元素的过程如果类型与泛型数组引用定义的类型不一致，则会产生类型转换异常(ClassCastException)
    public static void demo5() {
        /**
         * 1. 验证结论a
         */
        ArrayList<String>[] arrayLists; //声明带泛型的数组引用
//        ArrayList<String>[] arrayLists1 = new ArrayList<String>[10];//不能直接创建带泛型的数组对象
        ArrayList[] lists = new ArrayList[5];
        arrayLists = lists; //将普通数组赋值->带泛型的数组引用

        ArrayList<Integer> intlist = new ArrayList<>();
        intlist.add(100);

//        lists[0] = intlist;
        System.out.println(arrayLists[0]); //可以输出数组
//        System.out.println(arrayLists[0].get(0));//抛出类型转换异常

        ArrayList<String> stringlist = new ArrayList<>();
        stringlist.add("dolphinmind");

        lists[0] = stringlist;
        System.out.println(arrayLists[0]); //可输出数组
        System.out.println(arrayLists[0].get(0)); //可输出结果，String类型

        /**
         * 2. 通过java.lang.reflect.Array.newInstance(Class<T>)创建一个泛型数组
         */
        GenericsArray<String> stringGenericsArray = new GenericsArray<String>(String.class, 5);
        stringGenericsArray.put(0, "路飞");
        stringGenericsArray.put(1, "娜美");
        stringGenericsArray.put(2, "索隆");
        stringGenericsArray.put(3, "乌索普");
        stringGenericsArray.put(4, "乔巴");
        System.out.println(Arrays.toString(stringGenericsArray.getArr()));
        System.out.println(stringGenericsArray.get(2));

    }

    /**
     * 测试
     */
    private static void demo6() {
//        ArrayList<Apple, Fruit>  //错误语法，只能传入一个参数，纯属好奇进行的测试，虽然源码已经规定只能传入一个参数
    }
}








