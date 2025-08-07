package com.youcai.day09._06ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：
 * 1.   一个线程在获取该锁后，还可以继续再次获取该锁。这个锁就是可重入锁
 * 2.    synchronized也是可重入锁，是方法重入的
 *
 *
 * ReentrantLock        lock
 * {
 *     privat int count
 *     private Thread tid = null
 * }
 * 每获取一次 count++
 * 每释放一次 count--
 */
public class ReentrantLockDemo01 {
    public static void main(String[] args) {
        //定义一个显示锁对象
        ReentrantLock rl = new ReentrantLock(true);

        Runnable r = ()->{
            //显示调用锁对象的lock(),进行上锁
            rl.lock();

            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }finally {
                //在同步块后调用unlock(),进行释放锁
                rl.unlock();
            }
        };
        for (int i = 0; i < 4; i++) {
            new Thread(r).start();
        }
    }
}
