package com.youcai.day09._06ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个人去购票中心买票。可能买一张，也可能买多张
 */
public class DReentrantLockDemo02 {
    public static void main(String[] args) {
        TicketCenter tc = new TicketCenter(10);
        Thread p1 = new Person("张三",tc,(int)(Math.random()*10 + 1));
        Thread p2 = new Person("蔡徐坤",tc,(int)(Math.random()*10 + 1));
        Thread p3 = new Person("王五",tc,(int)(Math.random()*10 + 1));
        Thread p4 = new Person("赵六",tc,(int)(Math.random()*10 + 1));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
class Person extends Thread{
    private TicketCenter tc;
    private int ticket;
    public Person(String name, TicketCenter tc, int ticket) {
        super(name);
        this.tc = tc;
        this.ticket = ticket;
    }
    public void run() {
        try {
            tc.buyMore(ticket);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
class TicketCenter{
    private int tickets;
    private ReentrantLock rt = new ReentrantLock();
    public TicketCenter(int tickets) {
        this.tickets = tickets;
    }
    public void buyOne() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "正在尝试获取锁----");
        if(rt.tryLock(5, TimeUnit.SECONDS)){
            System.out.println(Thread.currentThread().getName() + "获取到了锁对象");
            if(tickets > 0){
                this.tickets--;
                System.out.println(Thread.currentThread().getName() + "成功购买了一张票");
            }else {
                System.out.println(Thread.currentThread().getName() + ":f**k,没票了");
            }
            rt.unlock();
        }else {
            System.out.println(Thread.currentThread().getName() + ":时间超时，八嘎雅鹿");
        }
    }
    public void buyMore(int number) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "正在尝试获取锁----");
        if(rt.tryLock(5, TimeUnit.SECONDS)){
            System.out.println(Thread.currentThread().getName() + "获取到了锁对象");
            if(tickets >= number){
                tickets -= number;
                System.out.println(Thread.currentThread().getName() + "成功购买了" + number +"张票");
            }else {
                System.out.println(Thread.currentThread().getName() + ":f**k,没票了");
            }
            rt.unlock();
        }else {
            System.out.println(Thread.currentThread().getName() + ":时间超时，八嘎雅鹿");
        }
    }
}