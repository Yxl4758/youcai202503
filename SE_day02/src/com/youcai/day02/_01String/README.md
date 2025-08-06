#### 字符串

###### 一、简介

是由若干个字符组成的一个有序的序列。用String类来描述字符串

String位于java.lang包下，不需要import，直接使用。

String类型使用了final修饰词，因此不能被继承（不能有子类型）

字符串底层封装的是字符数组及其针对数组的操作方法

字符串一旦创建，对象永远无法改变，但字符串引用可以重新赋值   

字符串在内存中采用Unicode编码方式，任何一个字符对应两个字节的定长编码  

字符串的索引值从0开始  

###### 二、字符串常量池

Jvm为了提升性能和减少内存开销，避免重复创建字符串，维护了一块特殊的内存空间，就是字符串常量池。

1. 在JDK1.7以前字符串常量池在方法区中
2. 在JDK1.8字符串常量池被移动到了堆中

易错

```
String s1 = "abc"; //
String s2 = "abc";
System.out.println(s1 == s2); //true
```

```
String s3 = "abc"+"d";
String s4 = "abcd";
System.out.println(s3 == s4); //true
```

```
// 拼接操作只要有变量参与，那么javac不会进行优化。只能在运行期间进行计算，
// 计算后的结果，存储在堆中，并不是常量池里
String s6 = "abc"+s5;
System.out.println(s6 == s4); //false
```

###### 三、StringBuilder和StringBuffer

字符串是不可变的，对字符串进行操作时比较麻烦每次的操作都需要实例化一个 临时的空间来存放结果，效率不高。可以使用其他的某些类，来实现高效率的字符串的操作：StringBuilder和StringBuffer。

StringBuilder和StringBuffer，都是一个可变的字符序列(即可变的字符串)，对象创建后可以通过调用方法来实现字符序列的改变，StringBuilder和StringBuffer类中的方法完全相同。

###### 四、String、StringBuilder、StringBuffer三者的区别

1.可变性：

​	String是不可变的。

​	StringBuilder和StringBuffer是可变的

2.线程安全性

​	String是不可变的，所以是线程安全的

​	StringBuilder不是线程安全的，但它是并发处理的执行速度快，效率高

​	StringBuffer是线程安全的，但是同步处理执行速度慢，效率低

3.equals

​	StringBuilder和StringBuffer没有重写equals方法，String重写了equals方法

###### 五、练习题

1.equals() 和 equalsIgnoreCase() 方法有什么区别？

重写的equals方法比较的是字符串常量是否相同。equalsIgnoreCase() 在比较时忽略大小写

2.解释 String 的 intern() 方法的作用和使用场景

intern() 方法用于在运行时将字符串添加到内部的字符串常量池中，并返回字符串常量池中的引用。

当调用 intern() 方法时，如果字符串常量池已经包含该字符串，则返回池中的引用，如果池中没有该字符串，则将其添加到池中，并返回该字符串的引用。

3.什么是不可变对象？为什么 String 要设计成不可变的？

不可变对象：指该对象创建后，不能再改变对象的状态。不能改变状态指对象中的成员变量不能再改变，包括基本数据类型。引用类型的变量指向的对象不能再改变，也不能再指向别的对象。

1.线程安全的	2.支持Hash映射	3.数据安全	4.字符常量池优化

4.分析以下代码的性能问题，并提供优化方案：

```
String result = "";
for (int i = 0; i < 10000; i++) {
    result += "a";
}
```

```
StringBuilder sb = new StringBuilder(10000);  // 预分配容量
for (int i = 0; i < 10000; i++) {
    sb.append('a');  // 直接追加字符，避免创建临时字符串
}
String result = sb.toString();
```

优化原理：

1. **可变字符序列**：`StringBuilder` 内部维护可扩展的 `char[]`，直接修改数组而不创建新对象。
2. **预分配容量**：`new StringBuilder(10000)` 一次性分配足够空间，避免动态扩容（默认容量不足时需复制数据到新数组）。
3. **时间复杂度优化**：每次 `append` 操作是 𝑂(1)*O*(1)（平摊时间），总时间复杂度降至 𝑂(𝑛)*O*(*n*)。
4. **减少对象创建**：全程只生成 1 个 `StringBuilder` 和 1 个最终 `String` 对象。