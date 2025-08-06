package com.youcai.day06._02IO._01FileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输出流之文件输入流：FileInputStream
 * 1.   输入流、字节流、低级流
 * 2.   构造器
 *          FileInputStream(File file)
 *          FileInputStream(String name)
 * 3.   常用方法
 *          int  read()
 *          int 　read(byte[] 　b)    将读取到的字节存储到bs数组中，返回读取自己的有效长度
 *          int　 read(byte[] b, int off, int len)   将读取的字节存储到bs数组中，从指定位置off开始向后存储。读取len个字节
 * */
public class IODemo02 {
    public static void main(String[] args) throws IOException {
        //1 创建
        try {
            FileInputStream fis = new FileInputStream("D:\\youcai20\\a.txt");
            int b1 = fis.read();
            int b2 = fis.read();
            int b3 = fis.read();
            System.out.println((char)b1 + " " + (char)b2 + " " + (char)b3);
            //想要连续读取十个自己
            byte[] bs = new byte[10];
            int len = 0;
            /*while ((len = fis.read(bs,3,3)) != -1) {
                System.out.println(new String(bs,0,len));
            }*/
            int read = fis.read(bs, 0, 4);
            System.out.println(Arrays.toString(bs));
            //重置
            //关闭
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //2 读

        //3 关闭
    }
}
