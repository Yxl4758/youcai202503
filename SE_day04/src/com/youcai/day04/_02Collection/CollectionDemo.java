package com.youcai.day04._02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合的父接口Collection：
 * 1. 该接口有三个子接口：List Set Queue
 * 2. 该接口提供了集合的常用方法
 * */
public class CollectionDemo {
    public static void main(String[] args) {
        // 1、实例化一个  ArrayList 对象，并向上转型为  Collection 类型。
//    向上转型后的对象，只能访问父类或者接口中的成员
//    在这里，collection 将只能够访问  Collection 接口中的成员。
        Collection<String> collection = new ArrayList<>();

// 2、向集合中添加元素
        collection.add("michael");
        collection.add("tom");
        collection.add("lucy");
        collection.add("lilei");
        System.out.println(collection);

// 3、向集合中批量的添加元素（将一个集合中的元素依次添加到这个集合中）
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("lily");
        collection1.add("lucy");
        collection.addAll(collection1);
        System.out.println(collection);
// 4、删除从前往后第一个匹配的元素
        collection.remove("lucy");
        System.out.println(collection);
// 5、准备另外一个集合
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("jack");
        collection2.add("rose");
        collection2.add("tom");
// 6、删除所有的在另外一个集合中存在的元素
//   删除逻辑：遍历集合，将每一个元素带入到参数集合中判断是否存在，如果存在，就删除这个元素。
        collection.removeAll(collection2);
        System.out.println(collection);
// 7、删除所有的满足条件的元素
//   删除逻辑：遍历集合，将每一个元素带入到参数方法中，如果返回值是true，需要删除这个元素。

        //collection.removeIf(element -> element.length() == 4);
        //System.out.println(collection);
// 8、清空所有
        //collection.clear();
        //System.out.println(collection);

// 9、保留在另外一个集合中存在的元素
//   逻辑：遍历集合，将每一个元素带入到参数集合中，判断是否存在，如果存在则保留这个元素，如果 不存在，删除
        Collection<String> collection3 = new ArrayList<>();
        collection3.add("lily");
        collection3.add("lilei");
        collection3.add("rose");
        collection.retainAll(collection3);
        System.out.println(collection);
// 10、判断集合中是否包含指定的元素
        System.out.println(collection.contains("lilei"));

// 11、判断参数集合中的每一个元素是否都在当前集合中包含
        System.out.println(collection.containsAll(collection3));

// 12、判断两个集合是否相同（依次比较两个集合中的每一个元素，判断是否完全相同）
//    只有当两个集合中的元素数量、元素一一对应
        Collection<String> collection4 = new ArrayList<>();
        collection4.add("lilei");
        collection4.add("lily");
        //collection4.add("rose");
        System.out.println(collection.equals(collection4));
// 13、判断一个集合是否为空
        System.out.println(collection.isEmpty());

// 14、获取一个集合中元素的数量，类似于数组长度
        System.out.println(collection.size());
// 15、转成  Object 数组
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
// 16、转成指定类型的数组
        String[] strings = collection.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
        System.out.println(strings[0].length());
    }
}
