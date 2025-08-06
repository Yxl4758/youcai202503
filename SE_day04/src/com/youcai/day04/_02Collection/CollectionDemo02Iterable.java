package com.youcai.day04._02Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo02Iterable {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<String>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        //1.增强for-each循环迭代
        for (String name : names) {
            System.out.println(name);
            //name.remove(name)     不能对集合进行修改的操作
        }
        //2.使用迭代器进行遍历  boolean hasnext()  E next  在使用迭代器时，不能调用集合对象自己的方法来修改元素
        //应该调用迭代器的方法来修改
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(iterator.next() + " ");
            if (element.equals("C")) {
                iterator.remove();
            }
        }
    }
}
