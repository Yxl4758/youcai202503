package com.youcai.day09._02Synchronized;

public class SynchronizedDemo02 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> Counter.sum(10,20,30));
        Thread t2 = new Thread(() -> Counter.sum(10,20,30));
        t1.start();
        t2.start();
    }
}
class Counter{
    private int count = 0;
    //将关键字放在非静态方法上时，锁对象是this 相当于synchronized(this){//代码片段包含了方法中的所有代码}
    public synchronized void add(){
        System.out.println(Thread.currentThread().getName() + "在调用add方法-start");
        int a = 10;
        int b = 20;
        int c = a + b;
        count++;
        int d = c + 30;
        System.out.println(Thread.currentThread().getName() + "在调用add方法-end");
    }

    /**
     *类名.class:     返回的是class类型的一个对象
     * Class:   用来描述其他类型的
     * Class的一个对象：用来描述一个具体类型
     * 如何得到一个Class的对象:只需要使用类名.class即可
     * Class的实例是单例的，即整个系统中，只有一个对象。
     *      String.class--->整个系统中只有一个
     *      Scanner.class--->整个系统中只有一个
     *      Counter.class--->整个系统中只有一个
     */
    public static synchronized void sum(int a, int b, int c){
        System.out.println(Thread.currentThread().getName() + "在调用add方法-start");
        int x = a*2;
        int y = b*2;
        int z = c*2;
        System.out.println("三个参数的二倍的和" + ( x + y + z));
        System.out.println(Thread.currentThread().getName() + "在调用add方法-end");
    }
}