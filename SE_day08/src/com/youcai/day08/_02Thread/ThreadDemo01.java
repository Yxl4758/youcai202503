package com.youcai.day08._02Thread;

/**
 * Thread:  构造器
 *          Thread(Runnable target)
 *          Thread(Runnable target, String name)
 *          Thread(String name)
 * 线程的意义就是定义任务并执行。任务需要定义在run方法中。
 *
 * 创建线程的方式：
 *          - 使用Tread的子类型定义任务
 *              - 定义子类型
 *              - 使用匿名内部类
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=1;i <= 100;i++){
                if(i % 2 != 0){
                    System.out.println(i);
                }
            }
        });
        Thread t2 = new MyThread();
        //调用start()方法启动线程
        t1.start();
        t2.start();
    }
}
//方式一：写法1
class MyThread extends Thread{
    public void run(){
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}