package com.youcai.day07._02BufferCharStream;

import java.io.*;

/**
 * 缓冲字符输入流：BufferedRider
 * 1    内部也是维护了一个缓冲区的。  磁盘的数据尽可能一次性的多存储到缓冲区里
 *      方法从缓冲区再次取数据
 * 2    构造器
 *          --使用指定字符集进行读取
 *              - BufferedReader(Reader reader)
 * 3.   readLine()方法读到文件末尾时，再次读取返回的是null。
 * */
public class BufferedRiderDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(".\\SE_day07\\b.txt"),"utf-8"),8192);
            String string = br.readLine();//读到换行符，但是不包含换行符
            System.out.println(string);
            string = br.readLine();
            System.out.println(string);
            string = br.readLine();
            System.out.println(string);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
