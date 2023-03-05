package com.dolphinmind.reflection;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        demo1();
        demo2();
    }

    public static void demo1() throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class<?> aClass = Class.forName("com.dolphinmind.reflection.Student");
        System.out.println("通过Class.forName创建Class对象："+aClass);
//        System.out.println(aClass.getMethods());

        //创建多个进行比较
        Class<?> bClass = Class.forName("com.dolphinmind.reflection.Student");
        Class<?> cClass = Class.forName("com.dolphinmind.reflection.Student");
        Class<?> dClass = Class.forName("com.dolphinmind.reflection.Student");
        Class<?> eClass = Class.forName("com.dolphinmind.reflection.Student");

        //一个类在内存中只有一个Class对象
        //一个类被加载后，整个类的结构都会被封装在Class对象中
//        System.out.println(aClass.hashCode());
//        System.out.println(bClass.hashCode());
//        System.out.println(cClass.hashCode());
//        System.out.println(dClass.hashCode());
//        System.out.println(eClass.hashCode());
        //结果hashcode是一致的

        System.out.println("通过类名.class获取Class对象："+Student.class);

    }

    public static void demo2() throws ClassNotFoundException {
        Person person = new Person();

        //method 1: By Object
        Class aClass = person.getClass();
        System.out.println(aClass);
        System.out.println(aClass.hashCode());

        //method 2: By forName method
        Class bClass = Class.forName("com.dolphinmind.reflection.Person");
        System.out.println(bClass);
        System.out.println(bClass.hashCode());

        //method 3: By Classname
        Class cClass = Teacher.class;
        System.out.println(cClass);
        System.out.println(cClass.hashCode());

        //method 4: 基本内置类型的包装类都有一个Type属性
        Class dClass = Integer.TYPE;
        System.out.println(dClass);

        //method 5: 获取父类类型
        Class fClass = cClass.getSuperclass();
        System.out.println(fClass);
        System.out.println(fClass.hashCode());

    }

}
