package com.dolphinmind._enum;

/* #枚举
 * 1. 比较两个枚举类型的值时，并不需要调用equals方法，只需要使用 == 即可
 * 2. 枚举类的构造器总是私有的，可省略。若声明一个enum构造器为public或protected，会出现语法错误
 */
public class EnumDemo {
    public static void main(String[] args) {
        Size size = Enum.valueOf(Size.class, "SMALL");
        System.out.println(size.getAbbreviation());
        System.out.println(size == Size.EXTRA_LARGE);
    }
}
