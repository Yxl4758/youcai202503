package com.youcai.day09._04Wait_Notify;


public class ThreadDemo01 {
    public static void main(String[] args) {
        Object lock = new Object();
        /**
         * 使用锁API来替换Join方法
         */
        Thread downLoadThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("图片正在下载：" + i + "%");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("图片下载完成");
                synchronized (lock) {
                    lock.notify();
                }
            }
        });
        Thread showThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 1; i <= 100; i++) {
                System.out.println("图片正在显示：" + i + "%");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("图片下载完成");
        });
        downLoadThread.start();
        showThread.start();
    }
}
