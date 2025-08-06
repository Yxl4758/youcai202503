package com.youcai.day08._04LifeMethod;

/**
 * void sleep(long mills): 线程睡眠方法
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 21; i <= 30; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.fillInStackTrace();
//        }
        System.out.println("-------------");
    }
}
