package com.youcai.day10._06Reflect;

public class Person {
    private  String name;
    int age;
    protected char gender;
    public double salary;
    public static final int MAX_AGE = 100;
    public static int bouns;

    private Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }

    public Person(String name, int age, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getPI() {
        return Math.PI;
    }

    private void show() {
        System.out.println("——————私有方法——————");
    }
}
