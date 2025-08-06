package Thread_Test.Test02;

import org.junit.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable和FutureTask使用
 *          创建一个实现 Callable 接口的任务，计算1-1000的质数个数。
 */
public class Test2 {
    @Test
    public void test() {
        FutureTask futureTask = new FutureTask(() -> {
            int count = 0;
            for (int i = 1; i <= 10000; i++) {
                if(isPrime(i))
                    count++;
            }
            return count;
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isPrime(int number) {
        if(number == 1) return false;
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
