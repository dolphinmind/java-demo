package com.dolphinmind._interface;

public class EmployeeA implements Comparable<EmployeeA> {
    private String name;
    private double salary;

    public EmployeeA(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double bypercent) {
        double raise = salary * bypercent /100;
        salary += raise;
    }

    @Override
    public int compareTo(EmployeeA other) {
        return Double.compare(salary, other.salary);
    }
}

