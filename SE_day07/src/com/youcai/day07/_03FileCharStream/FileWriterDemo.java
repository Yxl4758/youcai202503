package com.youcai.day07._03FileCharStream;

import java.io.FileWriter;
/**
 * try-with-resource写法
 * 1.   是finally模块里通常要进行流关闭的简单写法
 * 2.   如果要使用简写，流必须实现AutoCloseable接口或者其子类
 * 3.   写法
 *      try(代码片段){
 *
 *         }catch (Exception e) {
 *             e.printStackTrace();
 *         }
 *         - 省略finally模块
 *         - 代码片段是流对象的定义，需要关闭的流必须在该代码片段里
 * 4.   该简写会在流任务完成后自动关闭流对象
 * */
public class FileWriterDemo {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(".\\SE_day07\\c.txt")){
            fw.write('A');
            fw.write("中国");
            fw.write("蔡徐坤");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
