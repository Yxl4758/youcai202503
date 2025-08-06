package com.youcai.day05._03Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 底层维护了一个插入顺序的链表
 * */
public class MapDemo02LinkedHashMap {
    public static void main(String[] args) {
        Map<String,Integer> scores = new LinkedHashMap<>();
        scores.put("lucy",100);
        scores.put("lily",80);
        scores.put("王浩",120);
        scores.put("迈克",90);
        scores.put("罗航",100);
        System.out.println(scores);
        //使用keySet方式来遍历scores
        Set<String> keys = scores.keySet();
        for (String key : keys) {
            System.out.println(key + ":" + scores.get(key));
        }
        //使用EntrySet方式
        Set<Entry<String,Integer>> entries = scores.entrySet();
        for (Entry<String,Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //判断王浩是否在这个集合中，如果在则返回其成绩
        if(scores.containsKey("王浩")){
            System.out.println(scores.get("王浩"));
        }
    }
}
