package com.youcai.day03._04Date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDemo03 {
    public static void main(String[] args) {
        //获取时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //格式化
        //格式化器对象调用format方法
        //时间对象调用format传入格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(localDateTime));
        System.out.println(localDateTime.format(formatter));
        //时间字符串转日期
        String birthday = "2002-03-06 23:00:00";
        LocalDateTime localDateTime1 = LocalDateTime.parse(birthday, formatter);
        System.out.println(localDateTime1);

        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int week = localDateTime.getDayOfWeek().getValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println(year + "-" + month + "-" + day + "-" + week + "-" + hour + ":" + minute + ":" + second);
        localDateTime = localDateTime.plusYears(1).plusMonths(1).plusWeeks(1).plusDays(1);
        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date = " + date);

        Date date1 = new Date();
        Instant instant = date1.toInstant();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime2);
    }
}
