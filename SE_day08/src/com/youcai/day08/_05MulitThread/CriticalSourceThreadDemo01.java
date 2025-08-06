package com.youcai.day08._05MulitThread;

/**
 * 多个线程访问共同的资源
 * 1.   桌子上有100个豆子。
 * 2.   两个人分别去拿豆子，一个一个拿
 * 3.
 */
public class CriticalSourceThreadDemo01 {
    public static void main(String[] args) {
        Desk desk = new Desk(100);
        Thread p1 = new Person("张三",desk);
        Thread p2 = new Person("李四",desk);
        p1.start();
        p2.start();
    }
}
class Person extends Thread {
    private String name;
    private Desk desk;
    public Person(String name, Desk desk) {
        this.name = name;
        this.desk = desk;
    }
        //拿豆子
    public void takeBean(){
       synchronized (Person.class){
           System.out.print(name + "拿走了一个豆子，");
           desk.subBeanNum();
           System.out.println(desk);
       }
    }
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /**
             * 桌子上还有一个豆子。剩下一个豆子后，某一个人再次获取时间片段执行判断条件，条件成立，
             * 进入分支后恰好时间片段用完，紧接着下一个时间片段给了另外一个人，也去执行判断条件，条件也成立也进入了分支。
             * 此后，两个人不管谁先后获取时间片段，第二个人也进行了减豆子操作，就出现-1。
             */
            if(desk.getBeanNum() != 0){
                Thread.yield();
                takeBean();
            }else {
                break;
            }
        }
    }
}
class Desk{
    private int beanNum;

    public Desk(int beanNum) {
        this.beanNum = beanNum;
    }
    public void subBeanNum(){
        this.beanNum--;
    }

    public int getBeanNum() {
        return beanNum;
    }

    @Override
    public String toString() {
        return "桌子上剩余" + beanNum + "个豆子";
    }
}