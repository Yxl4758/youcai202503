package com.youcai.day03._01Regular;

import javax.sound.sampled.Line;
import java.util.Arrays;

/**
 * 字符串与正则表达式
 * 1. boolean matches(string regex)
 * 2. String split (String regex)
 *      如果字符串的开头就匹配到了正则表达式，则会切出一个空字符串的元素
 * 3. replaceAll(String regex, String replacement)
 * 4. replaceFirst(String regex, String replacement)
 * */
public class RegexDemo01 {
    public static void main(String[] args) {
        String str1 = "you are the best 123 456";
        String[] split = str1.split("\s");
        System.out.println(Arrays.toString(split));
        //将str里的空格和替换为#
        String string = str1.replaceAll("(\s|e)", "#");
        System.out.println(string);
        //将str里的数字替换为数字
        String string1 = str1.replaceFirst("\\d+", "数字");
        System.out.println(string1);
    }
}
