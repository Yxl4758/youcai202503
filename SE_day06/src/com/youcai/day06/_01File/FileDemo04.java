package com.youcai.day06._01File;

import java.io.File;

public class FileDemo04 {
    public static void main(String[] args) {
        //描述d1文件夹
        File f1 = new File("D:\\d1");
        //查看d1文件夹里的内容
        //String[] list = f1.list();
        File[] list1 = f1.listFiles();
        for (File s : list1) {
            System.out.println(s.getName());
            if (s.isDirectory()) {
                String[] list2 = s.list();
                for (String string : list2) {
                    System.out.println(string);
                }
            }
        }
    }
}
