package com.youcai.day07._07CollectionStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 集合的流式编程：不是IO流，是对集合元素进行操作的一个增强。
 * 流式编程分三步：
 *      1.  数据源的获取
 *      2.  中间操作
 *      3.  最终操作
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(10,20,30,40,50,60,70,80,90));
        //使用流式编程，关联数据源
        Stream<Integer> s1 = scores.stream();//该方法得到的流都是串行的，好比一个人操作集合
        //Stream<Integer> s2 = scores.parallelStream();//该方法得到的流都是并行的，好比多个人操作集合

        //1. collect方法：用来搜集流对象处理的元素
        //1.1 将流里的数据搜集成一个新的List表对象
//        List<Integer> collect1 = s1.collect(Collectors.toList());
//        System.out.println(collect1);

        //1.2将流里的数据搜集成一个新的Set对象
//        Set<Integer> collect2 = s1.collect(Collectors.toSet());
//        System.out.println(collect2);

        //1.3将流里的数据搜集成一个新的Map对象 集合元素作为value下标作为键
//        Map<Integer, Integer> collect3 = s1.collect(Collectors.toMap(scores::indexOf, v -> v));
//        System.out.println(collect3);

        //2. reduce方法：规约聚合
        //  (a,b) -> {}
        //  a,b第一次分别指向第一个元素和第二个元素
        //  后续的操作将结果聚合到a身上
//        Optional<Integer> reduce1 = s1.reduce(Integer::sum);
//        System.out.println(reduce1.get());
        //3.count() 返回流中的元素个数
        //System.out.println("s1.count() = " + s1.count());
        //4 for-each
        //s1.forEach(e -> System.out.print(e + " "));
        //双冒号表示引用 即将out的println方法作为形参传递给action
//        s1.forEach(System.out::println);
        //5 max & min
        //s1.max(Comparator.comparingInt(a -> a));//max返回的是排序后的最后一个元素
        //s1.min(Comparator.comparingInt(a -> a));//min返回的是排序后的第一个元素
        //6 Matching 匹配方法
//        boolean b = s1.allMatch(a -> a > 0);
//        System.out.println(b);
//        System.out.println(s1.anyMatch(e -> e > 5));
//        System.out.println(s1.noneMatch(e -> e > 20));
        // find - finndFirst: 从流中获取一个元素（一般情况下，是获取的开头的元素）
        //      - findAny: 从流中获取一个元素（一般情况下，是获取的开头的元素）
//        System.out.println(s1.findAny());
        System.out.println(s1.findFirst());
    }
}
