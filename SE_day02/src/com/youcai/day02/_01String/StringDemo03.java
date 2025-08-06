package com.youcai.day02._01String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

public class StringDemo03 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //1.将字符串hello和字符串world拼接起来
        String str1 = "hello";
        String str2 = "world";
        String s1 = str1.concat(str2); //拼接为一个新的对象
        System.out.println(s1);
        //2. 将字符串hello和world使用#拼接起来
        String s2 = str1.concat("#").concat(str2);
        System.out.println(s2);
        String s3 = String.join("#", str1, str2);
        System.out.println(s3);
        //3.计算s3变量的长度
        System.out.println("s3.length() = " + s3.length());
        //4.返回s3第四个索引处的字符
        System.out.println(s3.charAt(3));
        //5.查找world子字符串出现的位置
        System.out.println(s3.indexOf("world"));
        //6.查找.c字符串再url第一次出现的位置
        String url = "http://www.baidu.com.cn.com";
        System.out.println(url.indexOf(".c"));
        //7.从下表17开始查找.c
        System.out.println(url.indexOf(".c",17));
        //8.查找qq在url第一次出现的位置
        System.out.println(url.indexOf("QQ"));
        //9.查找5~20内.c第一次出现的位置
        System.out.println(url.indexOf(".c",5,20));
        //10.查找.c在url中最后一次出现的位置
        System.out.println(url.lastIndexOf(".c"));
        //11.查找.c在url中前21个中最后一次出现的方法
        System.out.println(url.lastIndexOf(".c",21));
        //12.将url中的字母全部大写
        System.out.println(url.toUpperCase());
        //13.将url2中的字母全部小写
        String url2 = "http://WWW.qq.com.123456.COM";
        System.out.println(url2.toUpperCase());
        //14将url2转成字符数组
        char[] ch = url2.toCharArray();
        System.out.println(ch);
        //15判断url是否以http://开头
        System.out.println("url2是否以http://开头：" + url2.startsWith("http://"));
        //16判断url是否以com结尾
        System.out.println("url2是否以com结尾：" + url2.toLowerCase().endsWith("com"));
        //17获取url中http://之后的内容
        System.out.println(url2.substring(7));
        //18截取url中的WWW.qq.com并转成大写
        System.out.println(url2.substring(7,17).toUpperCase());
        String name = "   michael tom   ";
        //19打印name的长度
        System.out.println(name.length());
        //20去除name两端的空格，并获取长度
        System.out.println(name.trim());
        String address = "长春市宽城区天泽凯旋华府";
        //21将address中的宽城区替换为高新区
        System.out.println(address.replace("宽城区","高新区"));
        //22获取字符串伟大的中国的字节序列
        String str3 = "伟大的中国";
        byte[] ch1 = str3.getBytes();
        System.out.println("伟大的中国字节序列：" + Arrays.toString(ch1));
        //23获取字符串伟大的中国的字节序列使用GB2312字节码表
        byte[] ch2 = str3.getBytes("GB2312");
        System.out.println("伟大的中国字节序列：" + Arrays.toString(ch2));
        //24使用无参构造器定义一个字符串对象x1，调用方法判断是否为空字符串
        String x1 = new String();
        System.out.println("x1是否为空：" + x1.isEmpty());
        String words = "you are the best";
        //25判断words是否包含字符串best
        System.out.println("是否包含best：" + words.contains("best"));
        //26对字符串进行排序
        String y1 = "hello";
        String y2 = "hella";
        int i = y1.compareTo(y2);
        System.out.println(i);
        //27 将3.1415926转成字符串
        double Pi = 3.1415926;
        System.out.println(String.valueOf(Pi));
    }
}
