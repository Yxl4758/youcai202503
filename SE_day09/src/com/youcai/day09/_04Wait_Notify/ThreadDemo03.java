package com.youcai.day09._04Wait_Notify;

/**
 * 使用三个线程分别打印十次ABC
 *      ABC
 *      ABC
 *      ABC
 *      。。。
 *      ABC
 */
public class ThreadDemo03 {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock3) {
                    try {
                        lock3.wait();
                        System.out.print("A");
                        synchronized (lock1) {
                            lock1.notify();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock1) {
                    try {
                        lock1.wait();
                        System.out.print("B");
                        synchronized (lock2) {
                            lock2.notify();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock2) {
                    try {
                        lock2.wait();
                        System.out.println("C");
                        synchronized (lock3) {
                            lock3.notify();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        a.start();
        b.start();
        c.start();
        /**
         * 上述三个线程卡住的原因：三个线程都进入了等待队列中，都等待其他线程唤醒
         * 因此出现了循环等待。我们需要某种手段打破循环
         * 可以借助main线程来唤醒
         */
        Thread.sleep(2000);
        synchronized (lock2) {
            lock2.notify();
        }
    }
}
