package com.youcai.day04._01Generic;
/**
 * 泛型：类型参数化，真正使用时，给这个参数赋值一个类型名
 * 泛型类：
 *  1.  指的是泛型应用在类上，位置在类名后，使用<>括起来
 * */
public class Generic01Class {
    public static void main(String[] args) {
        Person<Integer> p = new Person<>(1000);
        System.out.println("p = " + p);
        Person<String> student = new Student<>("S0001","张三");
        System.out.println("student = " + student);
    }
}
//定义一个类型，要求有一个成员变量，该成员变量的类型是可变的，即参数化
class Person<T>{
    T id;
    public Person(){};
    public Person(T id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + '}';
    }
}
//定义一个子类继承一个泛型类时，也是在应用泛型类，因此必须给泛型值赋值一个具体的类型名
//如果不给泛型赋值，则默认是Object类型，不会报错，只会警告
class Student<M> extends Person<M>{
    private M name;
    public Student(M id,M name){
        super(id);
        this.name = name;
    }

    public M getName() {
        return name;
    }

    public void setName(M name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + '}';
    }
}