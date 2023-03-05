package com.dolphinmind.abstractclass;

/* # 抽象类
 * 1. 抽象类中可以包含抽象方法、字段和具体方法。建议尽量将通用的字段和方法(不管是否为抽象的)放在超类(不管是否为抽象类)中
 * 2. 抽象类中子类保留抽象类中的部分或全部方法时，子类也需要标注为抽象类
 * 3. 抽象类不能够通过new进行实例化，但可引用一个具体子类的对象(非抽象子类的对象)。
 */
public class AbstractClassDemo {
    public static void main(String[] args) {

    }

    public static void demo1() {
        //1. 测试抽象类引用具体的子类实现
        Person p = new Student("Neking", "GeoPhysics");
        System.out.println(p.getDescription());

        //2. Person中的超类是否能够省略？抽象类无法构造对象，只能引用子类的对象，这些对象实现了父类抽象类的抽象方法。
        //   若没有父类抽象方法，而直接定义子类方法，则编译无法通过。(抽象类继承与普通继承并无两样)
        Person[] people = new Person[2];    //生成Person型的数组，而非实例化对象
        people[0] = new Student("Tom","Math");
        people[1] = new Employee("Sara", 1000);

//        System.out.println(people[0].getDescription());
//        System.out.println(people[1].getDescription());
        for(Person item : people) {
            System.out.println(item.getDescription());;
        }

    }

}







