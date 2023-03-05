package com.dolphinmind.functionalinterface.inherit;

public class Son extends Father {
    private int num;
    private int age;

    Son(){

    }

    @Override
    public void print(){
        this.num = 2;
        System.out.println("Son的print函数被执行了: "+num);
    }

    {
        System.out.println("子类被加载了!" + "num = " + num);
    }
}
