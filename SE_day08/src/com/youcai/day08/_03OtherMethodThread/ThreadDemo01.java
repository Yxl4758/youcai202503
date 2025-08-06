package com.youcai.day08._03OtherMethodThread;

/**
 * 线程的优先级：1~10个级别，数值越大级别越高
 *            优先级越高，cpu给其分配时间片段的概率就越大
 *            Java提供了三个常量来定义了三个级别的优先级：
 *              - Thread.MIN_PRIORITY   1
 *              - Thread.MAX_PRIORITY   5
 *              - Thread.NORM_PRIORITY  10
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        //获取该行代码所在的线程：获取当前线程对象
        Thread t1 = Thread.currentThread();
        System.out.println("线程名：" + t1.getName());
        System.out.println("线程Id：" + t1.threadId());
        System.out.println("线程优先级：" + t1.getPriority());
        System.out.println("线程状态：" + t1.getState());
        System.out.println("线程是否活着：" + t1.isAlive());
        System.out.println("线程是否为守护线程：" + t1.isDaemon());
        System.out.println("线程是否被打断：" + t1.isInterrupted());

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("线程优先级：" + t1.getPriority());
    }
}
