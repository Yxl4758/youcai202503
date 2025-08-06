package com.youcai.day08._01Stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListStreamDemo01 {

    Stream<Integer> stream;

    @Before
    public void init() {
        List<Integer> scors = Arrays.asList(1,2,3,4,5,6,4,5,6);
        stream = scors.stream();
    }

    /**
     * 测试mapToInt()方法
     */
    @Test
    public void testMapToInt() {
        //将每一个元素映射为int类型的数据
        stream.mapToInt(e -> e.intValue() + 100).forEach(System.out::println);
    }

    /**
     * 测试flatMap()方法
     */
    @Test
    public void testflatMap() {
        //flat: 碾平、压扁
        //flatMap: 压扁并映射称其他形式的数据
        //应用场景：一般都是对二位集合进行操作，比如将二维编程一位
        List<List<Integer>> gradescores = Arrays.asList(Arrays.asList(34,78,98),Arrays.asList(66,77,88),Arrays.asList(33,44,55));
        Stream<List<Integer>> s1 = gradescores.stream();
        s1.flatMap(List::stream).sorted((o1,o2) -> o2 - o1).forEach(System.out::println);
    }

    /**
     * 测试map()方法
     */
    @Test
    public void testMap() {
        //将每一个元素映射为其他的数据
        stream.map(String::valueOf).forEach(System.out::println);
    }

    /**
     * 测试Skip()方法
     */
    @Test
    public void testSkip() {
        //跳过前n个元素
        stream.skip(3).forEach(System.out::println);
    }

    /**
     * 测试limit()方法
     */
    @Test
    public void testLimit() {
        //取前maxSize个元素
        stream.limit(3).forEach(System.out::println);
    }

    /**
     * 测试sorted方法
     */
    @Test
    public void test() {
        stream.sorted((o1,o2) -> o2 - o1).forEach(System.out::println);
    }

    /**
     * 测试distinct()
     */
    @Test
    public void testDistinct() {
        //去除流中的重复元素
        stream.distinct().forEach(System.out::println);
    }

    /**
     * 测试filter方法
     */
    @Test
    public void testFilter() {
        //中间操作：每个方法的返回对象都是一个流
        stream.filter(ele -> ele % 2 == 0).forEach(System.out::println);
    }

    /**
     * findAny()通常返回的是集合中的第一个元素，如果是并行可能是别的元素
     */
    @Test
    public void testFindAny() {
        //测试FindAny()方法
        System.out.println(stream.findAny().get());
    }

    /**
     * findFirst()通常返回的是集合中的第一个元素
     */
    @Test
    public void testFind(){
        //测试finFirst()方法
        System.out.println(stream.findFirst().get());
    }
}
