package com.youcai.day06._02IO._04ObjectStream;

/**
 *序列化:将内存中的对象转成一个字节序列(字节数组).序列化的目的是存储或者传输
 * 反序列化：将一个字节序列转成内存中的对象
 * 1. 序列化的对象的类型必须实现Serializable接口
 * */
import java.io.*;
import java.util.Objects;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
           oos = new ObjectOutputStream(new FileOutputStream("D:\\youcai20\\object.txt"));
           Person p1 = new Person("张三",18,'男');
           oos.writeObject(p1);
            Person p2 = new Person("李四",20,'女');
            oos.writeObject(p2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
/**
 * 2. 序列化时，底层会给每个类型一个版本号，如果程序员不提供版本号，系统会随机生成一个。
 *    当序列化时的版本号和反序列化时的版本号不一致时，则会报不兼容问题。
 * 解决版本不兼容问题：写死版本号。即程序员自己提供版本号
 * 3. 如果在序列化时不想将某一个属性的值进行序列化，则可以使用transient对属性进行修饰，反序列化时会自动赋值为默认值
 * */
class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private  String name;
    private  int age;
    private transient char gender;

    public Person() {
    }


    public Person(String name,int age, char gender) {
        this.age = age;
        this.gender = gender;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}