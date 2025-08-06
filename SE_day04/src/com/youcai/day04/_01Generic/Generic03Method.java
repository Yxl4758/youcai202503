package com.youcai.day04._01Generic;
/**
 * 泛型方法：
 * 1. 泛型也可以只用在方法上
 * 2. 位置在返回值类型的前面
 * 3. 泛型方法只需要给形参传入具体的数据，类型是jvm主动推断出来的
 * */
public class Generic03Method {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(Myutil.eq(str1,str2));

        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println(Myutil.eq(sb1,sb2));
    }
}
class Myutil{
    public <T> void show(T t){
        System.out.println(t);
    }
    public static <T> boolean eq(T a, T b) {
        return a.equals(b);
    }
}