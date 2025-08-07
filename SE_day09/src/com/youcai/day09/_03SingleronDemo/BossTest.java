package com.youcai.day09._03SingleronDemo;

public class BossTest {
    static Boss b1 = null;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            b1 = Boss.getInstance();
            System.out.println(b1);
            Thread.yield();
        });
        Thread t2 = new Thread(() -> {
            b1 = Boss.getInstance();
            System.out.println(b1);
            Thread.yield();
        });
        t1.start();
        t2.start();
    }
}
