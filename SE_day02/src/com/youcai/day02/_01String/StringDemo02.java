package com.youcai.day02._01String;

import java.io.UnsupportedEncodingException;

/**
 * 常用构造器
 * */
public class StringDemo02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "";
        String s2 = new String("");
        System.out.println(s1 == s2);
        String s3 = "helloworld";
        String s4 = new String("helloworld");
        System.out.println(s3 == s4);
        byte[] bt = {48,49,50,51,52,53,54,55,56,57};
        String s5 = new String(bt);
        System.out.println(s5);
        byte[] line = {-28,-72,-83,-27,-101,-67,-28,-67,-96,-27,-91,-67};
        String s6 = new String(line);
        System.out.println(s6);
        String s7 = new String(line,"GBK");
        System.out.println(s7);
        String s8 = new String(line,3,6);
        System.out.println(s8);
        char[] chs = {'a','b','c','d','e','f','g','h'};
        String s9 = new String(chs);
        System.out.println(s9);
    }
}
