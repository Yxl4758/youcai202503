package com.youcai.day08._02Thread;

/**
 * 第二种创建线程的方式：使用Runnable接口来定义任务
 *                      - 定义子类型
 *                      - 匿名内部类
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        Runnable r1 = new MyTask();
        Runnable r2 = () -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 5 == 0) {
                    System.out.println(i);
                }
            }
        };
        Runnable r3 = () -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 5 == 0 && i % 3 == 0) {
                    System.out.println(i);
                }
            }
        };
        //Thread t1 = new Thread(r1);
        //Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        //t1.start();
        //t2.start();
        t3.start();
    }
}
class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}