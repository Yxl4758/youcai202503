package com.youcai.day09._05DeadLock;

public class DeadLockDemo01 {
    public static void main(String[] args){
        Runnable runnable1 = () -> {
            synchronized ("a") {
                System.out.println("线程A，持有了 a锁，在等待b锁 ");
                synchronized ("b") {
                    System.out.println("线程A同时持有了a锁和b锁 ");
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized ("b") {
                System.out.println("线程B，持有了b锁，在等待a锁 ");
                synchronized ("a") {
                    System.out.println("线程B同时持有了a锁和b锁 ");
                }
            }
        };

        new Thread(runnable1, "A").start();
        new Thread(runnable2, "B").start();
    }
}
