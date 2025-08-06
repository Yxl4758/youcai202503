package com.youcai.day07._01TransformStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符输出转换流
 * 1。   构造器
 *          OutputStreamWriter(OutputStream out,String charsetName)
 *          -:  指定字符集写数据
 *          OutputStreamWriter(OutputStream out)
 *          -:  使用系统默认字符集写数据，通常为UTF-8
 * 小提示：文件字节流中的路径，如果是相对路径，则相对的是项目名称这个文件夹
 * */
public class OutputStreamWriterDemo01 {
    public static void main(String[] args) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(".\\SE_day07\\a.txt",true),8192),"utf-8");
            //写一个字符
            osw.write("中");
            osw.write("国");
            //写一串字符
            char[] charArray = "是伟大的".toCharArray();
            osw.write(charArray);
            //写一个字符串
            osw.write("发展中国家a");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
