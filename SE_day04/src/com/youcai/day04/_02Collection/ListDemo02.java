package com.youcai.day04._02Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 如果想要在迭代过程中对集合进行操作，可以使用ListIterator
 * */
public class ListDemo02 {
    public static void main(String[] args) {
        List<Integer> ages = new ArrayList<Integer>();
        ages.add(18);
        ages.add(19);
        ages.add(20);
        ages.add(19);
        ages.add(21);
        ages.addAll(Arrays.asList(18, 19, 20, 21));
        //经典for循环
        for (int i = 0; i < ages.size(); i++) {
            System.out.println(ages.get(i));
        }
        //增强for循环
        for(Integer age:ages){
            System.out.println(age);
        }
        //使用迭代器子接口
        ListIterator<Integer> it = ages.listIterator();
        while(it.hasNext()){
            Integer age = it.next();
            if(age == 20){
//                it.remove();
                it.set(age*10);
            }
        }
        System.out.println(ages);
    }
}
