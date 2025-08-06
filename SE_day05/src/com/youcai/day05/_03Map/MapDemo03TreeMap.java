package com.youcai.day05._03Map;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MapDemo03TreeMap {
    public static void main(String[] args) {
        Map<Employee, Double> map = new TreeMap<>();
        map.put(new Employee("michael",20),3000.0);
        map.put(new Employee("lucy",18),2000.0);
        map.put(new Employee("lily",22),1000.0);
        System.out.println(map);

        //按照年龄降序
        Comparator<Employee> comparator = (o1, o2) -> o2.getAge()-o1.getAge();

        Map<Employee, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.put(new Employee("michael",20),3000.0);
        sortedMap.put(new Employee("lucy",18),2000.0);
        sortedMap.put(new Employee("lily",22),1000.0);
        System.out.println(sortedMap);
    }
}
class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "姓名：" + name + ", 年龄：" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Employee o) {
        return this.age - o.age;
    }
}