package com.youcai.day03._04Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) throws ParseException {
        // Date类型
        Date date = new Date();
        System.out.println(date);
        //getTime()获取事件毫秒值，距离1970，01.01 0:0:0:0毫秒的差值，该时间有一个专业的术语：纪元(本初子母线的时间点)
        //东八区(北京)比东一区(本初)早7个小时。
        System.out.println(date.getTime());
        date.setTime(0);
        System.out.println(date);
        // SimpleDateFormat 类型 用来指定日期的格式。将日期对象的数据格式化成字符串样式 format
        // 将日期字符串样式格式化为对应的日期对象 parse
        //常用的日期预定义符号。该类的构造器需要使用预定义的字符集
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd ahh:mm:ss");
        System.out.println(sdf.format(date));
        //将键盘录入的字符串转成日期对象
        String dateStr = "1986.11.08 07小时10分10秒";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh小时mm分ss秒");
        System.out.println(sdf1.parse(dateStr));
        //Calendar类 该类主要用来操作日期。
    }
}
