package com.youcai.day02._02Regular;

import javax.sound.sampled.Line;

/**
 * 正则表达式
 * 1. 概述
 *       是一种特殊的字符串，可以对其他的字符串进行校验，检查是否符合某一个规则
 *       独立的语法，脱离于编程语言的语法
 * 2. 字符集的写法
 * 3. 量词的语法
 * */
public class RegexDemo01 {
    public static void main(String[] args) {
        //
        //String line = "abc123def456";
        //定义一个正则表达式
        //String regex = "[a-z]+\\d+[a-g]{3}[0-9][0-9][0-9]";
//        String regex = "[a-z&&[^ahorux]]+";
//        String line = "abc";
//        System.out.println(line.matches(regex));
        //验证网址
        //String address = "http://www.baidu.com";
        //String address = "http://www.xxxx.com.cn";
        //String address = "http://www.xxxx.com.net";
        //String address = "http://www.xxxx.com.vip";
        //String address = "http://www.xxxx.com.org";
        //String address = "http://www.xxxx.com.cc";

        String regex = "(http|https)://[w]{3}\\.[a-zA-Z0-9]{3,20}(\\.com|\\.cn|\\.net|\\.vip|\\.vip|\\.cc)+";
    }
}
