package Thread_Test.Test03;

import org.junit.*;

/**
 * 线程状态控制（考察sleep和join两个方法）
 *   创建一个线程，实现以下功能：
 *   - 线程启动后运行5秒
 *   - 在第3秒时暂停2秒
 *   - 然后继续运行剩余时间
 *   - 主线程等待该线程结束后再退出
 */
public class Test3 {
    @Test
    public void threadStateContorl() throws InterruptedException {
        Thread pauseThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("暂停开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread mainThread = new Thread(() -> {
            System.out.println("-----主线程开始------");
            for (int i = 1; i <= 5; i++) {
                if (i == 3) {
                    try {
                        pauseThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    try {
                        System.out.println(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("-----主线程结束-----");
        });
        pauseThread.start();
        mainThread.start();
        Thread.sleep(10000);
    }
}
