package com.youcai.day06._02IO._01FileStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流之文件输出流：FileOutputStream
 * 1.   输出流、字节流、低级流
 * 2.   构造器
 * 3.   常用方法
 * 小贴士.   输出流构造器会创建不存在的文件，但是不会创建不存在的文件夹
 * */
public class IODemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建  2.写 3.关闭流
        //FileOutputStream fos = new FileOutputStream(new File("D:\\youcai20\\a.txt"));
        //FileOutputStream fos = new FileOutputStream("D:\\youcai20\\a.txt");
        //FileOutputStream fos = new FileOutputStream(new File("D:\\youcai20\\a.txt"),true);
        FileOutputStream fos = new FileOutputStream("D:\\youcai20\\a.txt",true);
        fos.write(65);
        byte[] bs = {65,66,67,68,69,70};
        fos.write(bs);
        fos.write(bs,2,3);
        fos.close();
    }
}
