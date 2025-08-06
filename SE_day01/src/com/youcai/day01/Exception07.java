package com.youcai.day01;

import java.io.IOException;

/**
 * throw和throws的区别
 * 1.位置上的区别
 *      -throw用在方法内部用来主动抛出一个异常
 *      -throws用在方法的定义结构上，即形参列表的后面，用来声明一个异常类型
 *          访问修饰词 返回值类型 方法名(参数列表) throws 异常类型名{
 *
 *          }
 * 2.功能去比如
 *      -throw：主动抛出异常
 *      -throws：声明，告知要处理的异常类型
 *
 *
 * */
public class Exception07 {
    public static void test1() throws IOException{
        try {
            String[] names = {"tom",null};
            int index = (int) (Math.random() * names.length);
            int length = names[index].length();
            System.out.println(index + "位置上的长度" +length);
        }catch (Exception e){
            //不处理异常，抛给调用者
            //throw e;
            //throw new RuntimeException("空指针异常");
            throw new IOException("检查性异常");
        }
    }

    public static void main(String[] args) {
        try {
            test1();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
