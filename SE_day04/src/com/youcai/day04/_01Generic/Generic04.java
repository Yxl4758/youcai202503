package com.youcai.day04._01Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generic04 {
    //?:泛型通配符。表示在定义期间关心的不是具体的类型
    //1. 在使用集合类型时，可以使用泛型通配符和使用T是一个效果
    //      我们关心的不是集合中的元素是什么类型
    //2.
    public static void print(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        // Integer 集合，可以运行
        List<Integer> intList = Arrays.asList(0, 1, 2);
        print(intList);
        System.out.println();
        // String 集合，可以运行
        List<String> strList = Arrays.asList("0", "1", "2");
        print(strList);

    }
    public static void calUp(List<? extends B> list) {

    }
    public static void calDown(List<? super D> list) {

    }
    public void test(){
        List<A> alist = new ArrayList<>();
        List<B> bList = new ArrayList<>();
        List<C> cList = new ArrayList<>();
        List<D> dList = new ArrayList<>();
        List<E> eList = new ArrayList<>();

        calUp(bList);
        calUp(cList);
        calUp(dList);
        calUp(eList);
    }
    public void test1(){
        List<A> alist = new ArrayList<>();
        List<B> bList = new ArrayList<>();
        List<C> cList = new ArrayList<>();
        List<D> dList = new ArrayList<>();
        List<E> eList = new ArrayList<>();

        calDown(bList);
        calDown(cList);
        calDown(dList);
        calDown(alist);
    }
}
class A{}
class B extends A{}
class C extends B{}
class D extends C{}
class E extends D{}
