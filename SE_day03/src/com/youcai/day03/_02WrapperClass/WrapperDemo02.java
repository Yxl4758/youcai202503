package com.youcai.day03._02WrapperClass;
/**
 * 包装类常量池
 * 1. jvm在堆中，维护了一个常量池，
 * 2. Byte, Short, Integer, Long 这 4 种包装类默认创建了数值 [-128, 127] 的相应类型的缓存数据
 * 3. Character 创建了数值在 [0, 127] 范围的缓存数据
 * 4. Boolean 直接返回 true 或 false。
 * 5. 两种浮点数类型的包装类 Float, Double 并没有实现常量池技术。
 * */
public class WrapperDemo02 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(-128);
        Integer i2 = -128;
        System.out.println(i1 == i2);

        Character c1 = Character.valueOf('a');
        Character c2 = 97;
        System.out.println(c1 == c2);

         Boolean b1 = Boolean.TRUE;
         Boolean b2 = true;

         Float f1 = Float.valueOf(123.456f);
         Float f2 = 123.456f;
         System.out.println(f1 == f2);  //false：说明没有常量池

        String line = "hello89world";
        String sub = line.substring(5,7);
        int num = Integer.parseInt(sub);
        System.out.println(num);

    }
}
