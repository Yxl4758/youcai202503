package com.youcai.day10._06Reflect;

/**
 * 反射机制:是在运行期间加载类的字节码文件，可以获取类的信息，
 *        可以动态的创建对象，可以调用类里的方法。
 *        对比
 *        即时编译期间：将字节码编译为机器码期间（该期间已经加载了字节码文件到内存中）
 * 反射机制API
 * 1    Class类型，该类的实例是Java的其他类型的描述类对象，用来描述Java的其他类型。
 *      描述信息可能有类名、属性、构造器、方法等
 *      获取该类实例的方法有三种
 *          1）对象.getClass
 *          2）类名.Class
 *          3）Class.forName("类全名")
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p1 = new Person("张三",20,'男',1000);
        //方法一：返回该类的描述类对象，不是反射
        //p1.getClass();
        //方式二：返回该类的描述类对象，不是反射
        //Class<Person> personClass = Person.class;
        //方式三：该行代码被翻译成机器码时，是不会触发Person.class文件加载的
        //       只有在运行时触发Person.class文件加载
        Class<?> clz = Class.forName("com.youcai.day10._06Reflect.Person");
        System.out.println(clz);
    }
}
