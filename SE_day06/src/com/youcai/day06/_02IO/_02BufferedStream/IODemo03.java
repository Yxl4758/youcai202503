package com.youcai.day06._02IO._02BufferedStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 构造器
 *      BufferedOutputStream(OutputStream out)
 *      BufferedOutputStream(OutputStream out, int size)
 *
 * */
public class IODemo03 {
    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\youcai20\\b.txt",true);
            bos = new BufferedOutputStream(fos);
            //写数据
            bos.write(65);  //数据被写入到了底层封装的缓冲区里了
            byte[] bytes = "中国".getBytes();
            bos.write(bytes);   //依旧是写道缓冲区里了
            byte[] bytes1 = {66, 67, 68, 69, 70};
            bos.write(bytes1, 1, 2);
            //如何将缓冲区里的数据写到磁盘上:两种方式:第一种 flush方法，第二种关闭流

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
