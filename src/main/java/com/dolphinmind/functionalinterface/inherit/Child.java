package com.dolphinmind.functionalinterface.inherit;

public class Child extends Base {
    public Child(String name){
        super(name);
        System.out.println("子类有参构造函数调用！");
    }
}
