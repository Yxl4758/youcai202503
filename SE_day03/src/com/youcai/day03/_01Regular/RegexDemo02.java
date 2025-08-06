package com.youcai.day03._01Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 如果想要使用正则表达式对一个普通字符串进行更细节的匹配和操作
 * 我们可以使用pattern和matcher类
 * 1. Pattern类：
 *      可以调用静态的compile(String regex),返回一个Pattern类
 *      然后通过Pattern对象调用natcher(String input)方法，返回i一个Matcher对象
 * 2. Matcher类：
 *      - matches()：判断字符串是否与正则表达式完全匹配
 *      - lookingAt()：判断字符串开头是否与正则表达式匹配
 *      - find():判断字符串是否有匹配正则表达式的字串
 *
 * */
public class RegexDemo02 {
    public static void main(String[] args) {

        //matches()方法
        String info = "123abc";
        Pattern p = Pattern.compile("\\d+");
        Pattern p1 = Pattern.compile("\\d+\\w+");
        Matcher matcher = p.matcher(info);
        Matcher matcher1 = p1.matcher(info);
        // 在使用find()方法时需要reset()方法将指针移动到开头，前面有可能有lookingAT()方法移动了指针。
        System.out.println(matcher.matches());//false
        System.out.println(matcher1.matches());//true
        //find()方法会移动指针，针对的是同一个matcher对象
    }
}
