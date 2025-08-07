package com.youcai.day09._04Wait_Notify;

/**
 * wait()
 * notify()
 * notifyAll()
 * 上述三个对象：锁对象的方法
 * 这三个方法需要同步块包裹
 * 同步代码块的意义：多个线程执行同一段逻辑，让其同步执行（串行）。可以解决临界资源安全隐患问题
 */
public class ThreadDemo02 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个锁对象
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("t1：获取锁后并释放，开始进入等待队列");
                    lock.wait();
                    System.out.println("t1：开始执行-----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * 下面的代码不再同步块中。因此t1和t2的该处代码的运行特点：可能交叉。
                 * 如果将其放入同步块中，t1和t2的该处代码的运行特点：不会交叉。
                 */
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1: A");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("t2：获取锁后并释放，开始进入等待队列");
                    lock.wait();
                    System.out.println("t2：开始执行-----");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("t2: B");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");
        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t3：获取锁后通知等待队列中的某个线程，继续运行");
                lock.notifyAll();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("t3: C");
            }
        },"t3");
        t1.start();
        t2.start();
        //若想要t1、t2都先获取锁并进入等待队列。t3可以慢点执行
        Thread.sleep(1000);
        t3.start();
    }
}
