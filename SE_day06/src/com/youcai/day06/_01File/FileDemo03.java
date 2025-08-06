package com.youcai.day06._01File;

import java.io.File;
import java.io.IOException;

public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        File f0 = new File("D:\\aaa\\bbb\\ccc");
        if (!f0.exists()) {
            f0.mkdirs();//多层级创建
        }

        File f1 = new File(f0,"ddd.txt");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        //delete 删除aaa文件夹
        File f2 = new File("D:\\aaa");
        f0 = new File("D:\\aaa");
        f0.delete();    //该方法只能删除空目录，或者文件
    }
}
