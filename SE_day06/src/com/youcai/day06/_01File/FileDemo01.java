package com.youcai.day06._01File;

import java.io.File;
import java.io.IOException;

/**
 * File: 用来描述磁盘上的一个文件或者文件夹,
 *      可以帮助我们创建、删除、重命名文件或者文件夹,
 *      也可以获取文件或者文件夹的属性信息。
 *      但是不能对文件里的内容进行访问
 * 常用构造器：
 *      - File(String  pathname)
 *      - File(File parent,String child)
 *      - File(String parent, String child)
 *
 * */
public class FileDemo01 {
    public static void main(String[] args) {
        File f1 = new File("D:\\youcai10");
        System.out.println("该文件夹是否存在：" + f1.exists());
        if (!f1.exists()) {
            f1.mkdir();
        }
        System.out.println("该文件夹是否存在：" + f1.exists());
        File f2 = new File(f1,"周考1.txt");
        if (!f2.exists()) {
            System.out.println("---开始创建---");
            try {
                f2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
