package com.youcai.day06._02IO._03DataStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * 字节流中的数据输出流:Data0utputStream
 * 该类的作用:主要就是提供了更多的方法来写出数据
 *
 * */
public class DataOutputStreamDemo01 {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("D:\\youcai20\\c.txt"));
            dos.writeByte(65);
            dos.writeShort(65);
            dos.writeInt(230000);
            dos.writeLong(1L);
            dos.writeFloat(3.14f);
            dos.writeDouble(3.14);
            dos.writeChar('中');
            dos.writeUTF("你干嘛~哈哈~哎呦");//每写一个UTF字符串后面都会自动加一个结束字符占两个字节
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
