package Thread_Test._01ThreadGroup;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1"){
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("运行异常");
            }
        });
        thread1.start();
    }
}
