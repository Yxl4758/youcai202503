package com.youcai.day06._01File;
import java.io.File;
import java.io.IOException;

public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\youcai");
        if (!f1.exists()) {
            f1.mkdir();
        }
        File f2 = new File(f1,"周考1.txt");
        if (!f2.exists()) {
            f2.createNewFile();
        }
        System.out.println("文件名；" + f2.getName());
        System.out.println("文件路径；" + f2.getPath());
        System.out.println("文件绝对路径File；" + f2.getAbsoluteFile());
        System.out.println("文件绝对路径Path；" + f2.getAbsolutePath());
        System.out.println("文件父路径；" + f2.getParent());
        System.out.println("可读文件；" + f2.canRead());
        System.out.println("可写文件；" + f2.canWrite());
        System.out.println("可执行文件；" + f2.canExecute());
        System.out.println("是文件；" + f2.isFile());
        System.out.println("是文件夹；" + f2.isDirectory());
        System.out.println("是隐藏文件；" + f2.isHidden());
        System.out.println("最后一次修改时间；" + f2.lastModified());
        //renameTo有移动的作用
        f1.renameTo(new File("D:\\youcai\\周考2.txt"));
        System.out.println(f2.getName());
    }
}
