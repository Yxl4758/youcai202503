package com.youcai.day03._02WrapperClass;
/**
 * 包装类是Java语言专门为了八大基本数据类型封装的类。因为八大基本数据类型，不满足面向对象的特征
 *      所以需要包装类来封装
 *      即每个包装类都是封装了对应的基本数据类型的一个属性和相关操作方法。
 * */
public class WarrperDemo {
    public static void main(String[] args) {
        //装箱：基本数据类型 → 对应的包装类型
        //1. 调用构造器
        //Integer i = new Integer(10);      过期
        //2. 调用静态方法
        Integer i = Integer.valueOf(10);
        double d1 = i.doubleValue();
        System.out.println(d1);
        //拆箱：调用对应的xxxvalue()方法
        int i1;
        i1 = i.intValue();
        System.out.println(i1);
        //自动装箱和拆箱
        Integer age = 10;   //装箱
        int age1 = age;     //拆箱
    }
}
