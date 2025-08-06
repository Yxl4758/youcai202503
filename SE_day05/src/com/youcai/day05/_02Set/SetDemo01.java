package com.youcai.day05._02Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Set接口：
 *      1.存储的元素是无序的
 *      2.存储的元素不能重复
 * 常用子类型：HashSet、LinkedHashSet、TreeSet
 *      - HashSet的特点：
 *          -- 1. 底层是使用Hash算法来计算元素的存储位置（数组+链表）
 *          -- 2. 先调用元素的hashcode方法经过Hash算法来计算存储的位置，如果该位置上没有元素
 *                就可以存储。如果该位置上有元素，再调用equals方法来比较两个元素是否相似
 *                如果相同就不存储，不同就存储
 *                为了避免hashcode相同，equals不同，元素应该重写hashcode和equals方法
 *                当想要自定义类型的对象存储到Set集合当中，需要重写hashcode和equals方法
 * */
public class SetDemo01 {
    public static void main(String[] args) {
        Person p1 = new Person("michael",20);
        Person p2 = new Person("tom",20);
        Person p3 = new Person("lily",20);
        Person p4 = new Person("lucy",20);
        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
        Person p5 = new Person("lucy",20);
        set.add(p5);
        System.out.println(set);
        // 添加一个叫张三，年龄18的人到集合中。不要临时存储该对象的地址。
        set.add(new Person("张三",18));
        //查找集合中是否有一个叫张三，年龄18的元素
        System.out.println(set.contains(new Person("张三", 18)));
        /**
         * 将一个对象存储到set集合后，就不要再修改这个对象的属性了，否则找不到。
         * 存储时使用的是旧的hash值进行计算的，查找时使用的是新值查找的，极大概率是找不到的
         * */
        //遍历set集合
        for (Person person : set) {
            System.out.println(person);
        }
        //迭代器
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }
        set.remove(p5);
        System.out.println(set);
    }
}
class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return  name +   ", " + age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}