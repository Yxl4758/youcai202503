package com.youcai.day10._01ProducerModel;

import java.util.LinkedList;

/**
 * 生产者消费者模型：
 * 1.  java程序的设计模式之一，是典型的多线程并发模型
 * 2.  该模型除了生产者，消费者两个角色外，还有一个角色，仓库
 */
public class ProducerConsumerWarehouseDemo {
    public static void main(String[] args) {
        //创建一个仓库角色对象
        FruitStand fruitStand = new FruitStand(100, 5);
        //创建8个生产者
        for (int i = 0; i < 8; i++) {
            new Producer(fruitStand,
                    (int)(Math.random()*50)+30,
                    "店员"+i).start();
        }
        //创建5个消费者
        for (int i = 0; i < 5; i++) {
            new Consumer(fruitStand,
                    (int)(Math.random()*50)+30,
                    "消费者"+i).start();
        }
    }
}

/**
 * 生产者角色
 */
class Producer extends Thread {
    //提供一个仓库角色的属性。
    private FruitStand fruitStand;
    //生产者准备生产的数量
    private int number;
    public Producer(FruitStand fruitStand, int number, String name) {
        super(name);
        this.fruitStand = fruitStand;
        this.number = number;
    }
    @Override
    public void run() {
        try {

            fruitStand.store( number);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
/**
 * 消费者角色
 */
class Consumer extends Thread {
    private FruitStand fruitStand;
    private int number;
    public Consumer(FruitStand fruitStand, int number, String name) {
        super(name);
        this.fruitStand = fruitStand;
        this.number = number;
    }
    public void run(){
        comsume();
    }
    public void comsume(){
        try {
            fruitStand.consume(number);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
// 水果摊(水果架子)，用来模拟仓库角色
class FruitStand {
    //维护一个链表的属性，用来存储苹果
    private LinkedList<Apple> apples = null;
    //维护一个最大容量的属性
    private int maxCapacity;

    /**
     * @param maxCapacity 最大容量
     * @param initSize    水果架子上的初始的苹果数量
     */
    public FruitStand(int maxCapacity, int initSize) {
        apples = new LinkedList<>();
        this.maxCapacity = maxCapacity;
        for (int i = 0; i < initSize; i++) {
            apples.add(new Apple());
        }
    }

    /**
     * 生产者调用的仓库的存储方法。
     *
     * @param number 生产者想要生产的苹果数量
     */
    public synchronized void store(int number) throws Exception {
        //可能该线程被唤醒之后去生产，但是生产前，还是应该再次判断是否可以生产，因此是循环。
        while (number + apples.size() > maxCapacity) {
            System.out.println(
                    Thread.currentThread().getName()
                            + "停止生产，进入等待队列，仓库空闲位置:"
                            + (maxCapacity - apples.size())
                            + ",其要生产数量：" + number);
            this.wait();
            System.out.println(
                    Thread.currentThread().getName() + "被唤醒，准备生产~~~");
        }
        //可以生产了
        for (int i = 0; i < number; i++) {
            apples.add(new Apple());
        }
        System.out.println(Thread.currentThread().getName() + "生产了" + number + "个苹果");
        //唤醒其他线程。
        this.notifyAll();
    }

    /**
     *  消费者需要调用的仓库的消费方法
     * @param number   消费者要购买的苹果数量
     * @throws Exception
     */
    public synchronized void consume(int number) throws Exception {
        while(number>apples.size()){
            System.out.println(
                    Thread.currentThread().getName()
                            + "停止消费，进入等待队列，仓库剩余数量:"
                            + apples.size()
                            + ",其要消费数量：" + number);
            this.wait();
            System.out.println(
                    Thread.currentThread().getName() + "被唤醒，准备消费~~~");
        }
        //可以消费了，使用删除方法来模拟消费
        for (int i = 0; i < number; i++) {
            //弹出头部元素
            apples.pop();
        }
        System.out.println(Thread.currentThread().getName() + "消费了" + number + "个苹果");
        //通知生产者，去生产
        this.notifyAll();
    }
}

//苹果类型
class Apple {
}
