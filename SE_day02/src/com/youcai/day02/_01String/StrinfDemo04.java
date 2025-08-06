package com.youcai.day02._01String;
/**
 * StringBuilder学习
 * 1.由于字符串是不可变的，因此对字符串进行操作的时候，比较的麻烦，每次的操作都需要实例化一个 临时的空间来存放结果，效率不高。
 *      可以使用其他的某些类，来实现高效率的字符串的操作：StringBuilder和StringBuffer。
 * 2.StringBuilder和StringBuffer，都是一个可变的字符序列(即可变的字符串)，对象创建后可以通过调用方法来实现字符序列的改变，
 *      StringBuilder和StringBuffer类中的方法完全相同。 只需要学会其中一个，另一个就会了。
 * */
public class StrinfDemo04 {
    public static void main(String[] args) {
        //1调用无参构造器创建一个StringBuilder对象
        StringBuilder s1 = new StringBuilder();
        //2调用一个参数的构造器创建对象
        StringBuilder s2 = new StringBuilder("我");
        //3 将字符串“love china”追加到s2后面
        s2.append("love china");
        //4 在我前面插入”帅气的“
        s2.insert(0,"帅气的");
        System.out.println(s2);
        //5 删除
        s2.deleteCharAt(1);
        System.out.println(s2);
        //6.替换
        s2.replace(2,7,"你爱");
        System.out.println(s2);
        //7.反转
        s2.reverse();
        System.out.println(s2);
        //8 将s2转为字符串
        String s3 = s2.toString();
        System.out.println(s3);
        String ss1 = "hello";
        String ss2 = "hello";
        System.out.println(ss1 == ss2);
    }
}
