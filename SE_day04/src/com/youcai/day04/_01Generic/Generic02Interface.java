package com.youcai.day04._01Generic;

/**
 * 泛型接口：
 * 1.   在接口上定义泛型
 * 2.   测试：
 *          - 实例化测试
 *          - 子类型实现泛型接口的测试
 * */
public class Generic02Interface {
    public static void main(String[] args) {
        Cat c1 = new Cat(10);
        Cat c2 = new Cat(20);
        int x = c1.compare(c1,c2);
        System.out.println(x);
    }
}
interface MyComparable<M,T>{
    int compare(M o1, T o2);
}
class Cat implements MyComparable<Cat,Cat>{
    private int age;
    public Cat(int age) {
        this.age = age;
    }
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age;
    }
}
