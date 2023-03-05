package com.dolphinmind.functionalinterface.inherit;

/* #继承与多态
 * 多态，面向对象的基础，正因为多态的存在，才可以在很多场景中使用抽象的方法解决问题，依赖于抽象而不是依赖于具体的实现
 *      操作对象的程序无需关注实际类型，既可以统一处理不同的对象，又可以实现每个对象的特定行为
 * eg: 帮母亲倒水时，我们只需要关注杯子这个容器所具备的功能属性，而不在乎是什么杯子去实现
 * eg: 搬家时，我们不必去追求用什么工具去实现(人、车、马等)
 *
 * #小结：
 * 1. 每个类有且只有一个父类，没有声明父类的，其父类为Object，子类继承父类非private的属性和方法，可增加自己的属性和方法，
 * 以及重写父类的方法和属性
 * 2. new过程中，父类先进行初始化，可通过super调用父类相应的构造方法，没有使用super的情况下，调用父类的默认构造方法
 * 3. 子类变量和方法与父类重名的情况下，可通过super强制访问父类的变量和方法
 * 4. 子类对象可以赋值给父类引用变量，这叫做多态；实际执行调用的是子类实现，这叫做动态绑定
 *
 */
public class InheritDemo {
    public static void main(String[] args) {
        Son son = new Son();
        son.print();

        System.out.println("####################");
        Father father = new Son();
        father.print();

        Base base = new Child("测试");
    }


    /* #继承的细节
     * 1. 构造方法
     * 2. 重名与静态绑定
     * 3. 重载和重写
     * 4. 父子类型转换
     * 5. 继承访问权限(protected)
     * 6. 可见性重写
     * 7. 防止继承(final)
     */

}







