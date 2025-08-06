package com.youcai.day04._02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * */
public class ListDemo01 {
    public static void main(String[] args) {
        // 1、实例化一个  List 接口的实现类对象，并向上转型为接口类型
        List<String> names = new ArrayList<>();
        // 2、增按照添加顺序维护索引
        names.add("A");
        names.add("A");
        names.add("B");
        // 3、在指定的位置插入元素
        names.add(0,"a");
        List<String> list = Arrays.asList("x", "y", "z");
        names.addAll(2,list);
        System.out.println(names);
        // 4、删除元素
        names.remove("A");
        System.out.println(names);
        // 5、按照下标删除元素
        names.remove(4);
        System.out.println(names);
        // 6、通过下标设置元素
        names.set(2,"you");
        System.out.println(names);
        // 7、通过下标获取元素
        System.out.println(names.get(3));
        // 8、获取某一个元素出现的下标
        System.out.println(names.indexOf("you"));
        // 9、获取某一个元素最后一次出现的下标
        names.add("A");
        names.add("A");
        names.add("A");
        names.add("A");
        names.addLast("B");
        names.addLast("B");
        names.addLast("B");
        names.addLast("B");
        names.addLast("B");
        System.out.println(names);
        System.out.println(names.lastIndexOf("B"));

    }
}
