package com.youcai.day06._02IO._04ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\youcai20\\object.txt"));
            Object o1 = ois.readObject();
            System.out.println(o1);
            Object o2 = ois.readObject();
            System.out.println(o2);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
