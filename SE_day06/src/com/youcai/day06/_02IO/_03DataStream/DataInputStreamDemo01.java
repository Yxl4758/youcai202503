package com.youcai.day06._02IO._03DataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo01 {
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("D:\\youcai20\\\\c.txt"));
            System.out.println("dis.readByte() = " + dis.readByte());
            System.out.println("dis.readShort() = " + dis.readShort());
            System.out.println("dis.readInt() = " + dis.readInt());
            System.out.println("dis.readLong() = " + dis.readLong());
            System.out.println("dis.readFloat() = " + dis.readFloat());
            System.out.println("dis.readDouble() = " + dis.readDouble());
            System.out.println("dis.readChar() = " + dis.readChar());
            System.out.println("dis.readUTF() = " + dis.readUTF());

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
