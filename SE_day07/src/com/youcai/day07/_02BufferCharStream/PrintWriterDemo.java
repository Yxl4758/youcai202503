package com.youcai.day07._02BufferCharStream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
/**
 * 缓冲字符输出流：
 * 1.   一般使用PrintWriter，二不是BufferedWriter，因为前者的功能更强大
 * 2.   构造器
 *          --使用默认字符集写数据
 *              - PrintWriter(OutputStream out)
 *              -  PrintWriter(OutputStream out,boolean autoFlush)
 *          --使用指定字符集写数据
 *              - PrintWriter(Writer writer)
 *              - PrintWriter(Writer writer,boolean autoFlush)
 * 3.   ln结尾的方法，每写一行，都会在末尾添加一个换行符号。
 * */
public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(".\\SE_day07\\b.txt"), "utf-8"),true);
            pw.println("你是最棒的");
            pw.println("你干嘛~哈哈~哎呦");
            pw.println("man");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
