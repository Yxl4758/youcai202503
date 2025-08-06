package com.youcai.day05._02Set;

import java.util.*;

/**
 * 集合的排序，以及工具类中的常用方法
 * */
public class SetDemo04 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("michael", 21);
        Teacher t2 = new Teacher("tom", 21);
        Teacher t3 = new Teacher("rose", 23);
        Teacher t4 = new Teacher("lucy", 22);
        Teacher t5 = new Teacher("jack", 24);
        //创建有序集合
        List<Teacher> ts = new ArrayList<>();
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        ts.add(t5);
        //调用集合工具排序
        Collections.sort(ts);  //自然拍寻-使用重写的compareTo方法
        //System.out.println(ts);
        // 年龄降序，相同情况下名字长度升序
        Collections.sort(ts, new Comparator<Teacher>() {

            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getAge() == o2.getAge() ? o1.getName().length() - o2.getName().length() : o2.getAge() - o1.getAge();
            }
        });
        //System.out.println(ts);
        List<Integer> ages = Arrays.asList(t1.getAge(), t2.getAge(), t3.getAge(), t4.getAge());
        System.out.println(ages);
        Collections.reverse(ages);
        System.out.println("反转后的样子：" + ages);
        Collections.shuffle(ages);
        System.out.println("打乱后的样子：" + ages);
        Collections.sort(ages);
        System.out.println("排序后的样子：" + ages);
        Collections.swap(ages,0,ages.size() - 1);
        System.out.println("第一与最后交换后的样子：" + ages);
        System.out.println("最小元素：" + Collections.min(ages));
        System.out.println("最大元素：" + Collections.max(ages));
        System.out.println("统计21出现的次数：" + Collections.frequency(ages,21));
        Collections.replaceAll(ages,21,200);
        System.out.println("200替换掉21：" + ages);
    }
}

/**
 * javaBean规范
 * 1.属性私有化
 * 2.提供至少两个构造器
 * 3.提供getter/setter方法
 * 4.重写equals和hashCode方法
 * 5.重写toString方法
 */
class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Teacher() {
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "姓名：" + name + ", 年龄： " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Teacher o) {
        return o.getAge() == this.getAge() ? o.getName().length() - this.getName().length() : this.getAge() - o.getAge();
    }
}