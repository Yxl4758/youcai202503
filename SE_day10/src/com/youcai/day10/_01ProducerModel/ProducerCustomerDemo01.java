package com.youcai.day10._01ProducerModel;

import java.util.LinkedList;
import java.util.List;

/**
 * 生产者消费者模型:
 * 1. java程序的设计模式之一，是典型的多线程并发模型
 * 2。 该模型除了生产者，消费者两个角色外，还有一个角色，仓库
 */
public class ProducerCustomerDemo01 {
    public static void main(String[] args) {
        FruitStand fruitStand = new FruitStand(100,5);
        for (int i = 0; i < 8; i++) {
            new Producer("生产者：" + i , fruitStand, (int)(Math.random()*10 + 10)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Customer("消费者者：" + i , fruitStand, (int)(Math.random()*10 + 10)).start();
        }
    }
}
class Customer extends Thread{
    private FruitStand fruitStand;
    private int number;

    public Customer(String name, FruitStand fruitStand, int number) {
        super(name);
        this.fruitStand = fruitStand;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            fruitStand.consume(number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Producer extends Thread{
    private FruitStand fruitStand;
    private int number;

    public Producer(String name, FruitStand fruitStand, int number) {
        super(name);
        this.fruitStand = fruitStand;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            fruitStand.store(number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
/**
 * 水果摊用来模拟仓库
 */
class FruitStand {
    private List<Apple> apples;
    //维护一个最大容量属性
    private int maxCapacity;

    public FruitStand(int maxCapacity, int initsize) {
        apples = new LinkedList<>();
        this.maxCapacity = maxCapacity;
        for (int i = 0; i < initsize; i++) {
            apples.add(new Apple());
        }
    }

    /**
     * 生产者调用的仓库的存储方法
     *
     * @param number 生产者想要生产的苹果数量
     */
    public synchronized void store(int number) throws InterruptedException {
        //唤醒后还应该再判断一下
        while (number + apples.size() > maxCapacity) {
            System.out.println(Thread.currentThread().getName() + ":f**k,仓库空闲位置：" + (maxCapacity - apples.size()) + "要生产的数量：" + number);
            this.wait();
            System.out.println(Thread.currentThread().getName() + " 可以继续添加啦！");
            for (int i = 0; i < number; i++) {
                apples.add(new Apple());
            }
            System.out.println(Thread.currentThread().getName() + " 生产了" + number + "个苹果");
            this.notifyAll();
        }
    }

    /**
     *
     * @param number 消费者要购买的苹果数量
     */
    public synchronized void consume(int number) throws InterruptedException {
        while (number >= apples.size()) {
            System.out.println(Thread.currentThread().getName() + "苹果不够辣，八嘎雅鹿");
            this.wait();
            System.out.println(Thread.currentThread().getName() + "消费！");
        }
        for (int i = 0; i < number; i++) {
            apples.removeFirst();
        }
        System.out.println(Thread.currentThread().getName() + "购买了" + number + "个苹果");
        this.notifyAll();
    }
}

class Apple {
}