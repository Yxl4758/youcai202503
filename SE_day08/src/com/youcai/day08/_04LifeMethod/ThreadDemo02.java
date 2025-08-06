package com.youcai.day08._04LifeMethod;

/**
 * yield(): 线程让步方法，作用是将正在使用的时间片段让出去，但是下一个时间片段是否给了谁。CPU说了算
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5 || i == 3 || i == 7) {
                    Thread.yield();
                }
                System.out.println(i);
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
