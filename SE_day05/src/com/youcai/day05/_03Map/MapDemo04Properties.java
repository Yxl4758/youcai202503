package com.youcai.day05._03Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties:
 * 1. property
 *
 * 2.Properties是HashTable接口的子实现类，专门用来存储Key-value都是String类型的键值对
 * 3.该类一般用来存储配置文件里的配置信息
 * */
public class MapDemo04Properties {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("url","jdbc:mysql://localhost:3306/dbname");
        map.put("username","root");
        map.put("password","123456");
        map.put("driver","com.mysql.jdbc.Driver");
        Properties prop = new Properties();
        prop.setProperty("url","jdbc:mysql://localhost:3306/dbname");
        prop.setProperty("username","root");
        prop.setProperty("password","123456");
        prop.setProperty("driver","com.mysql.jdbc.Driver");
        prop.getProperty("url");
    }
}
