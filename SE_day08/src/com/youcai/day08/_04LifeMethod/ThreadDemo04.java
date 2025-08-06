package com.youcai.day08._04LifeMethod;

/**
 * interrupt(): 打断谁，谁就调用
 */
public class ThreadDemo04 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println("正在睡觉。。。");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("你干嘛~哈哈~哎呦");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                for (int i = 0; i < 10; i++) {

                    System.out.println("曼波~曼波");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("墙到了");
                t1.interrupt();
            }
        };
        t1.start();
        t2.start();
    }
}
