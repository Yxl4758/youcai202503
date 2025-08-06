package com.youcai.day05._03Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 1.   不建议使用数组和有序集合
 * 2.   使用集合模块中的MAp
 * Map接口的设计初衷：用来存储一对一映射关系的数据，即键值对数据
 * 特点：
 *      1.Key不可以重复，value无所谓
 *      2.key可以为null，只能存一个
 *      3.key和value必须是引用类型的
 * */
public class MapDemo01 {
    public static void main(String[] args) {
        System.out.println("-----Map接口：HashMap、TreeMap------");
        Map<String,String> map = new HashMap<>();
        map.put("10001","michael");
        map.put("10002","tom");
        map.put("10003","lucy");
        map.put("10004","xiaoming");
        map.put("10005","zhangsan");
        map.put(null,"xiaohong");
        System.out.println("map的初始样子" + map);
        map.put("10005","xiaopohai");
        System.out.println("map的第二次样子" + map);
        System.out.println("map的长度" + map.size());
        //查看map是否包含了某一个key
        System.out.println(map.containsKey("10004"));
        System.out.println(map.get("10004"));
        //获取1010这个key的值，如果没有就返回不存在
        //如果指定K的值不存在，则返回null
        String value = map.getOrDefault("1010","不存在");
        System.out.println(value);

        //遍历Map集合
        //1.增强for循环 将其转成Set<Entry<K,V>>
        //entry类型，每一个键值对，都被封装成了Entry类型的实例
        //            Map里的内部类。
        Set<Entry<String,String>> entries = map.entrySet();
        for (Entry<String,String> entry : entries) {
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println(key + ":" + val);
        }
        //遍历Map集合的第二种方式     之便利Map里的value
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        for (String val : map.values()) {
            System.out.println(val);
        }
        map.clear();
        System.out.println(map);
    }
}
