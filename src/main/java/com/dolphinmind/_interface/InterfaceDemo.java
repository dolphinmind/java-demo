package com.dolphinmind._interface;

import java.util.Arrays;

public class InterfaceDemo {
    public static void main(String[] args) {

    }

    /**
     * Comparable接口
     */
    public static void demo1() {
        EmployeeA[] staff = new EmployeeA[3];
        staff[0] = new EmployeeA("Lucy", 35000);
        staff[1] = new EmployeeA("Tom", 50000);
        staff[2] = new EmployeeA("Jack", 40000);

        Arrays.sort(staff);

        for(EmployeeA e : staff) {
            System.out.println("name = " + e.getName() +", salary = " + e.getSalary());
        }
    }

    /**
     * Clone接口
     * @throws CloneNotSupportedException
     */
    public static void demo2() throws CloneNotSupportedException {
        EmployeeB employeeB = new EmployeeB("Jack",  500);
        employeeB.setHireDay(2021, 3, 5);
        System.out.println(employeeB.toString());

        EmployeeB copy = employeeB.clone();
        System.out.println(copy.toString());
        copy.setHireDay(2023,5,1);
        copy.raiseSalary(10);
        System.out.println(copy.toString());

        System.out.println(EmployeeB.class.getDeclaredMethods().length);
    }
}

