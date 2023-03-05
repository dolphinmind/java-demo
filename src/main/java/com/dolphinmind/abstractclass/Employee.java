package com.dolphinmind.abstractclass;

public class  Employee extends  Person {
    private double salary;

    public Employee(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return "a employee's salary = " + salary;
    }
}

