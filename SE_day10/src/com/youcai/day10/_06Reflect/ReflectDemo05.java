package com.youcai.day10._06Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 使用反射机制访问方法
 * 1.   成员方法
 * 2.   静态方法
 */
public class ReflectDemo05 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            Constructor<?> constructor = c1.getDeclaredConstructor();
            constructor.setAccessible(true);
            System.out.println("---------成员方法---------");
            Object o = constructor.newInstance();
            Method setName = c1.getDeclaredMethod("setName", String.class);
            setName.invoke(o,"张三");
            System.out.println(o);
            System.out.println("---------私有方法---------");
            Method show = c1.getDeclaredMethod("show");
            show.setAccessible(true);
            show.invoke(o);
            System.out.println("---------有返回值方法---------");
            Method getName = c1.getDeclaredMethod("getName");
            System.out.println(getName.invoke(o));
            System.out.println("---------静态方法---------");
            Method getPI = c1.getDeclaredMethod("getPI");
            getPI.setAccessible(true);
            System.out.println(getPI.invoke(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
