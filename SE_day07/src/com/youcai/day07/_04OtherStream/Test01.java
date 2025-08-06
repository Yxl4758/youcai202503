package com.youcai.day07._04OtherStream;

import java.io.*;
import java.util.Scanner;

/**
 * 1.   out是System的静态属性，是PrintStream类型，字节输出流。
 * 2.   查看某一个对象的类名，变量.class.getName();
 * 3.   PrintStream对象的目标位置是console(控制台)
 */
public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(System.out.getClass().getName());//out对象调用println方法将数据写到console窗口
        //使用out将数据写到d.txt里。
        PrintStream oldAddress = System.out; //临时保存原有流对象的地址
        System.setOut(new PrintStream(new FileOutputStream("d.txt")));
        System.out.println("hello world");
        System.out.println("ABCDEFG");
        System.out.println("AAA建材批发王总");
        System.out.println("你怎么这么自私~呸");
        System.out.println("装B我给你飞起来");
        //改回原有的效果
        System.setOut(oldAddress);
        System.out.println("hello world");

        //System.in是一个字节输入流，数据源是键盘
        InputStream old2 = System.in;
        //修改in这个静态属性的指为一个文件字节输入流
        System.setIn(new FileInputStream("d.txt"));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        //err与out流功能相似，只不过err输出的数据带有警告颜色
        //因此某些输出语句想要做到一个警告提醒的行为时，可以使用err

        System.err.println("神鹰黑手哥");
    }
}
