package com.youcai.day01;

import org.w3c.dom.ranges.RangeException;

import java.io.FileInputStream;

public class Exception02 {
    public static void main(String[] args) {
        /** 不存在继承关系的异常类型名 */
        try {
            String str = null;
            int a = str.length();
        }catch (IndexOutOfBoundsException e){
            System.out.println("------IndexOutOfBoundsException-------");
        }catch (NullPointerException e){
            System.out.println("------NullPointerException-------");
        }catch (RangeException e){
            System.out.println("------RangeException-------");
        }


        /** 存在继承关系的异常类型名 */
        try {
            FileInputStream fis = new FileInputStream("");
            //上述代码会出现IOException对象     和RuntimeException是并列关系
        }catch (RuntimeException e){
            System.out.println("------RuntimeException-------");
        }catch (Exception e) { //Exception 是 IOException父类型，因此变量e可以存储子类对象的地址
            System.out.println("---------Exception--------");
            e.printStackTrace();
        }
    }
}
