package com.youcai.day09._01DeamonThread;

/**
 * 守护线程：
 * 1.   线程分为用户线程和守护线程
 * 2.   当所有的前台线程执行完毕，守护线程会自动结束
 * 3.   如何设置守护线程，调用setDeanon(true)
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        /**
         * 场景模拟：
         *      roes:喊了十次，i will jump.......十次后跳进去
         *      jack:跟着喊 you jump, i jump
         */
        Thread rose = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i will jump.......");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("噗通！！");
            }
        });
        Thread jack = new Thread(new Runnable() {
            public void run() {
                for (; ;) {
                    System.out.println("you jump, i jump");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        jack.setDaemon(true);
        rose.start();
        jack.start();
    }
}
