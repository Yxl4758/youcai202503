package com.youcai.day03._03BigDecimal;

import java.math.BigDecimal;

public class BigDecimalDemo01 {
    public static void main(String[] args) {
        //调用构造器获取两个BigDecimal对象
        BigDecimal b1 = new BigDecimal("3.1234567890123456789");
        BigDecimal b2 = new BigDecimal("2.1234567890123456788");
        System.out.println(b1.subtract(b2));
        System.out.println(b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP));
    }
}
