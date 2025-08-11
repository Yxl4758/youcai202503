package com.youcai.day10._06Reflect;

import java.lang.reflect.Constructor;

/**
 * 反射机制创建对象
 * 1.   newInstance
 *          - 类里需要有无参构造器且公有
 * 2.   使用构造器的Instance
 */
public class ReflectDemo03 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            Constructor<?> dp = c1.getDeclaredConstructor(String.class, int.class, char.class, double.class);
            Object o = dp.newInstance("张三", 20, '男', 2000.0);
            System.out.println(o);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
