package com.youcai.day08._02Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的第三种方式：
 *      1. 创建Callable
 *      2. 创建FutureTask类型的对象，将Callable传入
 *      3. 创建Thread对象，将FutureTask传入进来
 */
public class ThreadDemo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable c = () -> {
            int x = new Random().nextInt(10);
            int y = new Random().nextInt(10);
            int z = new Random().nextInt(10);
            return x + y + z;
        };
        //get()有阻碍线程的方法
        FutureTask ft = new FutureTask<>(c);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
