package com.youcai.day05._01Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 子接口Queue
 * 1. Queue规范
 *      Queue规定了一种队列结构。先进先出
 *      LinkedList类实现了该规范
 * 2. Queue的子接口Deque
 *      规定了一种双端队列结构。两端都可以进或者出
 *      LinkedList类实现了Depue规范
 *      从队首进 offerFirst 从队尾进 offerLast
 *      从队首出pollFirst   从队尾出 pollLast
 * 3. 栈Stack：先进后出。可以使用Deque模拟栈，只需要调用队首的相关方法。
 * 4. 对应的方法：offer(E e) 从队尾进队
 *              E pool 从队首进队
 *              E peek() 查看队首元素
 * */
public class QueueDemo01 {
    public static void main(String[] args) {
        System.out.println("———————————Queue——————————");
        Queue<String> names = new LinkedList<>();
        names.offer("micheal");
        names.offer("tom");
        names.offer("lucy");
        System.out.println("names = " + names);
        System.out.println(names.peek());//查看
        while (names.peek() != null) {
            System.out.println(names.poll());
        }
        System.out.println("————————————队列中已经没有元素了————————————————");
        System.out.println("———————————Dueue——————————");
        Deque<String> deque = new LinkedList<>();
        //从队首进和出
        deque.offerFirst("A");
        deque.offerFirst("B");
        deque.offerFirst("C");
        //从队首出
        deque.pollFirst();
        deque.pollFirst();
        System.out.println(deque);
        //从队尾进和出
        deque.offerLast("X");
        deque.offerLast("Y");
        deque.offerLast("Z");
        System.out.println(deque);
        deque.pollLast();
        System.out.println(deque);
        System.out.println("———————————Dueue模拟Stack——————————");
        //只需要调用从队首进从队尾出。或者push和pop
        Deque<String> stack = new LinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        while(stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }
}
