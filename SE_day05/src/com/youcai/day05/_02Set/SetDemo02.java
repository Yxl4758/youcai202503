package com.youcai.day05._02Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo02 {
    public static void main(String[] args) {
        Set<Person> ps = new LinkedHashSet<Person>();
        ps.add(new Person("zhangsan", 18));
        ps.add(new Person("lily", 18));
        ps.add(new Person("wfui", 18));
        ps.add(new Person("jabfuejia", 18));
        System.out.println(ps);
    }
}
