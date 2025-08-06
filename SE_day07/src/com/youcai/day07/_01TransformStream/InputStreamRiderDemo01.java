package com.youcai.day07._01TransformStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 字符输入转换流
 * 1。   构造器
 *          InputStreamReader(InputStream in,String charsetName)
 *          基于给定的字节输入流以及字符集创建字符输入流
 *          InputStreamReader(InputStream in)
 *          该构造方法会根据系统默认字符集创建字符输入流
 * */
public class InputStreamRiderDemo01 {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(".\\SE_day07\\a.txt"),8192));
            int read = isr.read();
            System.out.println((char)read);
            char[] chs = new char[20];
            int read1 = isr.read(chs);
            System.out.println(new String(chs,0,read1));
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
