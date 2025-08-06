package com.youcai.day01;
/**
 * 如何处理异常：
 *   1. 只需要将书写try/catch将可能出现异常的代码片段放入其中
 *         try{
 *             //放置可能出现异常的代码
 *         }catch(异常类型名 变量名){
 *             //出现异常后执行的代码
 *         }
 * */
public class Exception01 {
    public static void main(String[] args) {
        try {
            String[] names = new String[]{"michael", "tom", null, "lucy", "lily"};
            int index = (int)(Math.random() * names.length);

            int length = names[index].length();
            System.out.println(index + "位置上的名字长度" + length);
        }catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        }
        int a = (int)(Math.random() * 10);
        int b = (int)(Math.random() * 10);
        System.out.println("a和b的乘积：" + (a*b) );
    }
}
