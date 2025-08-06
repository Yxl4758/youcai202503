package com.youcai.day05._02Set;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
/**
 * TreeSet：
 * 1.   里面存储的元素必须实现Comparable接口
 * 2.   向TreeSet集合里添加元素时的去重原理实际上时调用重写的ComparTo方法
 * 3.   TreeSet还支持使用比较器进行自定义排序
 * */
public class SetDemo03 {
    public static void main(String[] args) {
        Cat c1 = new Cat(2);
        Cat c2 = new Cat(3);
        Cat c3 = new Cat(2);
        Set<Cat> set = new TreeSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);
        System.out.println(set);
        set.add(new Cat(1));
        System.out.println(set);
        //对上述的四只猫，添加到集合中进行年龄降序排序
        Set<Cat> set1 = new TreeSet<>(new Comparator<Cat>() {

            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        set1.add(c1);
        set1.add(c2);
        set1.add(c3);
        set1.add(new Cat(1));
        System.out.println(set1);
    }
}
class Cat implements Comparable<Cat> {
    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" + "age=" + age + '}';
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(age);
    }

    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;
    }
}