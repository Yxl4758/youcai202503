package com.youcai.day10._02ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 * 1.   其实就是提供了一些静态方法，来帮助我们获取一个线程池对象。
 */
public class ThreadPoolExecutorsDemo02 {
    public static void main(String[] args) {
        /**
         * 创建一个固定大小的线程池对象，只有核心线程
         *  等待队列的大小为Integer.MAX_VALUE
         */
        //ExecutorService pool = Executors.newFixedThreadPool(5);
        /**
         * 创建一个可缓存的线程池对象，没有核心线程，如果有任务要做，则开辟临时线程
         *      临时线程的个数与任务的个数相当
         */
        //ExecutorService pool = Executors.newCachedThreadPool();
        /**
         * 创建一个单线程池的对象，只有一个核心线程
         */
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            //pool.execute(new MyTask(i));
            pool.schedule(new MyTask(i),5, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }
}
class MyTask implements Runnable{
    private int id;
    public MyTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":\t" + i + "\tid:" + id);
        }
    }
}