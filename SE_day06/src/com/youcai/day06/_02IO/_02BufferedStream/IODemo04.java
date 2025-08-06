package com.youcai.day06._02IO._02BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 构造器
 *      BufferedInputStream(OutputStream out)
 *      BufferedInputStream(OutputStream out, int size)
 *
 * */
public class IODemo04 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\youcai20\\b.txt");
            bis = new BufferedInputStream(fis);
            //读数据
            int read = bis.read();  //当我们调用方法读取时，底层先一次性尽可能多的将数据读取到缓冲区中，然后我们的方法是从缓冲区拿数据
            System.out.println(read);
            byte[] bs = new byte[10];
            int size = bis.read(bs);
            System.out.println("拿到了" + size + "个数据" + new String(bs, 0, size));
            /**
             * 当缓冲区里的教据被拿完了:
             * 如果文件中还有数据，会再次一次性的尽可能多的读取数据存储到缓冲区
             **/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
