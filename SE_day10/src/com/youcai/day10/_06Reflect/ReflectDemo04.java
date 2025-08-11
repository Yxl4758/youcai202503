package com.youcai.day10._06Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 使用反射机制访问属性
 * 1.   访问成员属性
 * 2.   访问静态属性
 */
public class ReflectDemo04 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            Constructor<?> dc = c1.getDeclaredConstructor(String.class, int.class,char.class,double.class);
            dc.setAccessible(true);
            Object o = dc.newInstance("小明", 20, '男', 1000.0);
            System.out.println(((Person) o).getName());
            //获取成员属性 age
            Field age = c1.getDeclaredField("age");
            age.setAccessible(true);
            //修改属性值
            age.set(o, 30);
            //获取属性值
            System.out.println(age.get(o));
            System.out.println(o);
            //访问静态属性    与对象无关，因此第一个参数
            Field bouns = c1.getDeclaredField("bouns");
            bouns.set(null,7000);
            System.out.println(bouns.get(null));
            //final修饰的常量不能再修改了
            Field MAX_AGE = c1.getDeclaredField("MAX_AGE");
            System.out.println(MAX_AGE.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
