package com.youcai.day09._03SingleronDemo;

public class Boss {
    private static Boss instance;
    private Boss() {

    }
    public static synchronized Boss getInstance() {
        if (instance == null) {
            instance = new Boss();
        }
        return instance;
    }
}
