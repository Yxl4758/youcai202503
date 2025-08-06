package com.youcai.day03._04Date;

import java.util.Calendar;

public class DateDemo02 {
    public static void main(String[] args) {
        //获取日历
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        System.out.println("year = " + year);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("month = " + month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("day = " + day);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("hour = " + hour);
        int minute = calendar.get(Calendar.MINUTE);
        System.out.println("minute = " + minute);
        int second = calendar.get(Calendar.SECOND);
        System.out.println("second = " + second);
        int a = calendar.get(Calendar.AM_PM);
        System.out.println("a = " + a);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("week = " + week);
        //修改为出生年月日
//        calendar.set(Calendar.YEAR, 1986);
//        calendar.set(Calendar.MONTH, 10);
//        calendar.set(Calendar.DAY_OF_MONTH, 8);
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
//        //将日历对象转为date对象
//        System.out.println(calendar.getTime());
//        calendar.add(Calendar.DATE, 30);
//        System.out.println(calendar.getTime());
        //打印2025年每月的天数
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.DAY_OF_MONTH,10);
        for (int i = 1; i <= 12; i++) {
            calendar.set(Calendar.MONTH, i - 1);
            //调用该方法时要保证年月日的日要小于等于28
            int dates = calendar.getActualMaximum(Calendar.DATE);
            System.out.println(i + "月有" + dates + "天");
        }
    }
}
