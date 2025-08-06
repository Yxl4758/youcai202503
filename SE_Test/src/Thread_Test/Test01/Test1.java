package Thread_Test.Test01;

import org.junit.Test;

/**
 * 课后习题：创建线程的方式
 *          请用两种不同的方式创建并启动线程，分别打印10次的"Hello from Thread-1"和"Hello from Thread-2"。
 */
public class Test1 {
    @Test
    public void creatThread01() {
        Thread t1 = new Thread(){
            public void run(){
                for(int i=1;i<=10;i++){
                    System.out.println("Hello from Thread-1");
                }
            }
        };
        t1.start();
    }
    @Test
    public void creatThread02() {
        Thread t1 = new Thread(() -> {
            for(int i=1;i<=10;i++){
                System.out.println("Hello from Thread-2");
            }
        });
        t1.start();
    }
}
