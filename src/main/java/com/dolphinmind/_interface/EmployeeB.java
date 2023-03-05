package com.dolphinmind._interface;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeB implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public EmployeeB(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    //建立深拷贝
    public EmployeeB clone() throws CloneNotSupportedException {
        EmployeeB cloned = (EmployeeB) super.clone();

        cloned.hireDay = (Date) hireDay.clone();

        return  cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee_2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}

