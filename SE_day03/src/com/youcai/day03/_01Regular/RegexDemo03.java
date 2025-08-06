package com.youcai.day03._01Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 如果matcher对象调用了matches()|lookingAt()|find()并匹配成功的情况下
 * 我们就可以继续使用group()、start()、end()方法来获取字串的信息。
 * */
public class RegexDemo03 {
    public static void main(String[] args) {
        String info = "123abc456def789";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(info);
        int count = 0;
        while (matcher.find()){
            //想要使用group()等方法必须时在匹配方法返回true的前提下
            String group = matcher.group();
            System.out.println(group);
            count++;
        }
        matcher.reset();
        for (int i = 0; i < count; i++) {
            matcher.find();
            if(i == 2){
                System.out.println(matcher.group());
            }
        }
        System.out.println("——————————————————");
        matcher.reset();
        //找到789出现的位置
        while (matcher.find()){
            if(matcher.group().equals("789")){
                System.out.println(matcher.start());
            }
        }
        System.out.println("——————————————————");
        matcher.reset();
        //找到789结束的位置
        while (matcher.find()){
            if(matcher.group().equals("789")){
                System.out.println(matcher.end());
            }
        }
    }
}
