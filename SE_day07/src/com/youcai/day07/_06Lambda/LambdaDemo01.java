package com.youcai.day07._06Lambda;

import java.util.Arrays;
import java.util.Scanner;

public class LambdaDemo01 {
    public static void main(String[] args) {
        /**
         * 使用匿名内部类，来定义一个函数式接口的函数式接口的实例
         */
        NoReturnParameter a = new NoReturnParameter() {
            @Override
            public void random() {
                System.out.println(Math.random());
            }
        };
        a.random();
        /*
         * lambda表达式
         *      1.就是匿名内部类的简写
         *      2.本质是匿名函数
         */
        NoReturnParameter b = () -> System.out.println(Math.random());
        b.random();
        //无返回值 一个形参
        NoReturnOneParameter c= round -> System.out.println("随机数范围[0," + round + "):" + (int)(Math.random()*round));
        c.random(10);
        //无返回值 多个形参
        NoReturnMutilParameter d = (x,y,z) -> {
            double max = Math.max(Math.max(x, y), z);
            System.out.println("max = " + max);
        };
        d.max(10,20l,5.0);

        ReturnNoParameter e = () -> {
            char[] chs = new char[4];
            int index = 0;
            while(index < 4){
                int result = (int)(Math.random()*58 + 65);
                if((char)result >= 'A' && (char)result <= 'Z'){
                    chs[index++] = (char)result;
                } else if ((char)result >= 'a' && (char)result <= 'z') {
                    chs[index++] = (char)result;
                }
            }
            return new String(chs);
        };
        System.out.println("四位验证码为：" + e.randomCheckCode());

        ReturnOneParameter f = x -> {
            Scanner sc = new Scanner(System.in);
            int[] scores = new int[x];
            System.out.println("请输入" + x + "个学生的数据：");
            for (int i = 0; i < x; i++) {
                int result = sc.nextInt();
                scores[i] = result;
            }
            return scores;
        };
        System.out.println("学生成绩为：" + Arrays.toString(f.inputScores(5)));
    }
}
/*定义三个函数式接口：
 *       1. 有返回值  -   无参数
 *       2. 有返回值  -   一个参数
 *       3. 有返回值  -   多个参数
 *
 * */
interface ReturnNoParameter{
    //随机产生大小写混合的四个字母作为验证码
    String randomCheckCode();
}
interface ReturnOneParameter{
    //录入n个学生的成绩，返回一个数组
    int[] inputScores(int n);
}
interface ReturnMutilParameter{
    //返回三个数中的最大值
    double max(int a, long b, double c);
}
/*定义三个函数式接口：
*       1. 无返回值  -   无参数
*       2. 无返回值  -   一个参数
*       3. 无返回值  -   多个参数
*
* */
interface NoReturnParameter{
    void random();
}
interface NoReturnOneParameter{
    void random(int rand);
}
interface NoReturnMutilParameter{
    void max(int a, long b, double c);
}

/**
 * 函数式接口，只有一个抽象方法的接口的就是函数式接口
 * 注解@FunctionalInterface，可以验证该接口是不是函数式接口
 */
@FunctionalInterface
interface inter {
    void m1();
    //void m2();
}