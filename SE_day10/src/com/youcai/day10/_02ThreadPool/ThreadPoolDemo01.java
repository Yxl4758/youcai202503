package com.youcai.day10._02ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 临时线程，当线程池中的任务数量大于超出核心线程+等待队列的长度，会创建临时线程
 * 临时线程，开始处理的是没有添加到队列中的任务
 * 如果临时线程处理完额外的任务后，会帮助核心线程处理队列中的任务
 * 拒绝策略：
 *      任务数量>核心线程数量+最大临时线程数量+等待队列，会执行拒绝策略
 *      策略：
 *          ThreadPoolExecutor.AbortPolicy
 *                          丢弃新的任务，并抛出异常 RejectedExecutionException
 *          ThreadPoolExecutor.DiscardPolicy
 *                          丢弃新的任务，但是不会抛出异常
 *          ThreadPoolExecutor.DiscardOldestPolicy
 *                          丢弃等待队列中最早的任务
 *          ThreadPoolExecutor.CallerRunsPolicy
 *                          不会开辟新的线程，由调用的线程来处理
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,
                10, 10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());
        //添加任务
        Runnable a = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":\t" + i);
            }
        };
        //向线程池中添加任务
        for (int i = 1; i <= 16; i++) {
            tpe.execute(a);
        }
        //关闭线程池
        tpe.shutdown(); //线程全部执行完毕后再关闭
        //tpe.shutdownNow();//强制关闭。线程执行完当前任务后立即关闭，队列中的任务不再执行。
    }
}
