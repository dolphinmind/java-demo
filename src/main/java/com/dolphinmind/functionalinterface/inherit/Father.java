package com.dolphinmind.functionalinterface.inherit;

public class Father {
    private int num = 1;

    public void print() {
        System.out.println("Father: "+num);
    }

    {
        System.out.println("父类被加载了！"+ "num = " + num);
    }

}
