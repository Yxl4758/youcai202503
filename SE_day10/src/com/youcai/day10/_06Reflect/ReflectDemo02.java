package com.youcai.day10._06Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * calss常用API
 */
public class ReflectDemo02 {
    public static void main(String[] args) {
        //testFile();
        //testConstructor();
        testMethod();
    }

    public static void testMethod(){
        try {
            Class c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            Method[] declaredMethods = c1.getDeclaredMethods();
            for (Method m : declaredMethods) {
                System.out.println(m);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testConstructor(){
        try {
            Class c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            //获取指定的某个构造器
            //Constructor dc = c1.getDeclaredConstructor(String.class);
            Constructor[] declaredConstructors = c1.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                System.out.println(constructor);
            }
            //System.out.println(dc);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFile() {
        try {
            Class c1 = Class.forName("com.youcai.day10._06Reflect.Person");
            Field[] fields = c1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getModifiers() + " " + field.getType().getName() + " " + field.getName());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
