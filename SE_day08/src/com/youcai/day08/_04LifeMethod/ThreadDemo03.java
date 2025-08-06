package com.youcai.day08._04LifeMethod;

import java.sql.SQLOutput;

/**
 * void join()方法：
 *          当前线程正在运行时，日过想让别的线程加进来，就使用别的线程对象调用该方法
 *          当前线程进入阻塞状态
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        /**
         * 需求：
         *      下载图片是一个线程
         *      显示图片是一个线程
         *      通常情况下应该是先下载，后显示
         */
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1 ; i < 101; i++) {
                    System.out.print("正在下载 " + i);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            public void run() {
                //显示前应该先下载完成
                try {
                    th1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //join的线程执行完毕后，当前线程进入了可运行状态、，等待cpu分配时间片段。
                for (int i = 1 ; i < 101; i++) {
                    System.out.print("正在加载： " + i);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        th1.start();
        th2.start();
    }
}
