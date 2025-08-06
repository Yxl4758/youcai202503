## IO流基础

##### 一、简介

###### 1.1 简介

​	Input：指数据流入程序，通常我们读取外界数据时使用，所以输入是用来读取数据的

​	Output：是指数据流出程序，通常我们需要写出数据到外界时使用，所以输出是用来写出数据的

###### 1.2IO流分类

​	1）按数据流向分

​		输入流、输出流（ 输出流构造器会创建不存在的文件，但是不会创建不存在的文件夹）

​	2）按处理数据的单位分类

​		字节流和字符流

​	3）按流的功能分

​		节点流：可以从一个特定的IO设备上读/写数据的流。也称之为低级流

​		处理流：是对一个已经存在的流的连接和封装，通过所封装的流的功能调用实现数据读/写操作。通		常处理流的构造器上都会带有一个其他流的参数。也称之为高级流或者过滤流

![](F:\Java培训\typroa图片\节点流.png)

###### 1.3IO流体系结构

![](F:\Java培训\typroa图片\IO流体系结构.png)

##### 三、字节流

InputStream是字节输入流的顶级父类，是抽象类。定义了基本的读取方法。OutputStream是字节输出流的顶级父类，也是抽象类，定义了基本的写出方法

1）InputStream定义的方法

| 返回值类型-方法名                      | 作用                                                         |
| -------------------------------------- | ------------------------------------------------------------ |
| int  read()                            | 从输入流中读取一个字节，把它转换为0-255之间的整数，并返回这一整数，如果返回-1，说明读到文件末尾(EOF) |
| int 　read(byte[] 　b)                 | 从输入流中读取若干个字节，把它们保存到缓冲区b中，返回的整数表示读取的字节数，如果遇到输入流的结尾，返回-1 |
| int　 read(byte[] b, int off, int len) | 从输入流读取最多 len字节的数据到一个字节数组。从指定下标off开始存。返回的整数表示实际读取的字节数。如果遇到输入流的结尾，返回-1 |
| void close()                           | 关闭输入流                                                   |
| int  available()                       | 返回可以从输入流中读取的字节数目                             |
| long  skip(long n)                     | 从输入流中跳过参数n指定数目的字节                            |
| boolean  markSupported()               | 测试这个输入流是否支持 mark和 reset方法。                    |
| void mark(int readLimit)               | 标记此输入流中的当前位置。                                   |
| void  reset()                          | 将此流重新定位到上次在此输入流上调用 mark方法时的位置。      |

2）OutputStream定义的方法

| 返回值类型-方法名                      | 作用                                                         |
| -------------------------------------- | ------------------------------------------------------------ |
| void  write(int b)                     | 向输出流写出一个字节                                         |
| void  write(byte[] b)                  | 将 b.length字节从指定的字节数组写入此输出流                  |
| void  write(byte[] b,int off, int len) | 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流 |
| void  close()                          | 关闭输出流                                                   |
| void  flush()                          | OutputStream类本身的flush方法不执行任何操作，它的一些带缓冲区的子类覆盖了flush方法，该方法强制把缓冲区内的数据写到输出流中 |

###### 3.1常用字节流

1）文件流（FileOutputStream、FileInputStream）

```
/**
 * 字节输出流之文件输出流：FileOutputStream
 * 1.   输出流、字节流、低级流
 * 2.   构造器
 *			FileOutputStream(File file)
 *			FileOutputStream(String filename)
 *			FileOutputStream(File file,boolean append)
 *			FileOutputStream(String filename,boolean append)
 * 3.   常用方法
 * 小贴士.   输出流构造器会创建不存在的文件，但是不会创建不存在的文件夹
 * */
```

```
/**
 * 字节输出流之文件输入流：FileInputStream
 * 1.   输入流、字节流、低级流
 * 2.   构造器
 *          FileInputStream(File file)
 *          FileInputStream(String name)
 * 3.   常用方法
 *          int  read()
 *          int 　read(byte[] 　b)    将读取到的字节存储到bs数组中，返回读取自己的有效长度
 *          int　 read(byte[] b, int off, int len)   将读取的字节存储到bs数组中，从指定位置off	*	开始向后存储。读取len个字节
 * */
```

2)缓冲流（BufferedOutputStream、BufferedInputStream）

```
/**
 * 构造器
 *      BufferedOutputStream(OutputStream out)
 *      BufferedOutputStream(OutputStream out, int size)
 *
 * */
public class IODemo03 {
    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\youcai20\\b.txt",true);
            bos = new BufferedOutputStream(fos);
            //写数据
            bos.write(65);  //数据被写入到了底层封装的缓冲区里了
            byte[] bytes = "中国".getBytes();
            bos.write(bytes);   //依旧是写道缓冲区里了
            byte[] bytes1 = {66, 67, 68, 69, 70};
            bos.write(bytes1, 1, 2);
            //如何将缓冲区里的数据写到磁盘上:两种方式:第一种 flush方法，第二种关闭流

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

```
/**
 * 构造器
 *      BufferedInputStream(OutputStream out)
 *      BufferedInputStream(OutputStream out, int size)
 *
 * */
public class IODemo04 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\youcai20\\b.txt");
            bis = new BufferedInputStream(fis);
            //读数据
            int read = bis.read();  //当我们调用方法读取时，底层先一次性尽可能多的将数据读取到缓冲区中，然后我们的方法是从缓冲区拿数据
            System.out.println(read);
            byte[] bs = new byte[10];
            int size = bis.read(bs);
            System.out.println("拿到了" + size + "个数据" + new String(bs, 0, size));
            /**
             * 当缓冲区里的教据被拿完了:
             * 如果文件中还有数据，会再次一次性的尽可能多的读取数据存储到缓冲区
             **/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

3）数据流（DataOutputStream、DataInputStream）

```
/**
 * 字节流中的数据输出流:Data0utputStream
 * 该类的作用:主要就是提供了更多的方法来写出数据
 *
 * */
public class DataOutputStreamDemo01 {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("D:\\youcai20\\c.txt"));
            dos.writeByte(65);
            dos.writeShort(65);
            dos.writeInt(230000);
            dos.writeLong(1L);
            dos.writeFloat(3.14f);
            dos.writeDouble(3.14);
            dos.writeChar('中');
            dos.writeUTF("你干嘛~哈哈~哎呦");//每写一个UTF字符串后面都会自动加一个结束字符占两个字节
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public class DataInputStreamDemo01 {
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("D:\\youcai20\\\\c.txt"));
            System.out.println("dis.readByte() = " + dis.readByte());
            System.out.println("dis.readShort() = " + dis.readShort());
            System.out.println("dis.readInt() = " + dis.readInt());
            System.out.println("dis.readLong() = " + dis.readLong());
            System.out.println("dis.readFloat() = " + dis.readFloat());
            System.out.println("dis.readDouble() = " + dis.readDouble());
            System.out.println("dis.readChar() = " + dis.readChar());
            System.out.println("dis.readUTF() = " + dis.readUTF());

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

4）对象流（ObjectOutputStream、ObjectInputStream）

序列化：将一个对象转换为字节序列的过程

反序列化：将一个字节序列转换为对应对象的过程

```
/**
 *序列化:将内存中的对象转成一个字节序列(字节数组).序列化的目的是存储或者传输
 * 反序列化：将一个字节序列转成内存中的对象
 * 1. 序列化的对象的类型必须实现Serializable接口
 * 2. 序列化时，底层会给每个类型一个版本号，如果程序员不提供版本号，系统会随机生成一个。
 *    当序列化时的版本号和反序列化时的版本号不一致时，则会报不兼容问题。
 * 解决版本不兼容问题：写死版本号。即程序员自己提供版本号
 * 3. 如果在序列化时不想将某一个属性的值进行序列化，则可以使用transient对属性进行修饰，反序列化时会自动赋值为默认值
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
```

```
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\youcai20\\object.txt"));
            Object o1 = ois.readObject();
            System.out.println(o1);
            Object o2 = ois.readObject();
            System.out.println(o2);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
```

##### 四、字符流

Reader是字符输入流的父类，抽象类；Writer是字符输出流的父类，抽象类。字符流是以字符(char)为单位读写数据的，一次处理一个unicode；字符流的底层仍然是基本的字节流。

1）Reader的常用方法

| 返回值类型-方法名                                | 作用                   |
| ------------------------------------------------ | ---------------------- |
| int read()                                       | 读一个字符             |
| int read(char[] cbuf)                            | 将字符读入数组         |
| abstract int read(char[] cbuf, int off, int len) | 将字符读入数组的一部分 |

2）Writer常用方法

| 返回值类型-方法名                                  | 作用                   |
| -------------------------------------------------- | ---------------------- |
| void write(char[] cbuf)                            | 将一个字符数组写出去。 |
| abstract void write(char[] cbuf, int off, int len) | 写入字符数组的一部分。 |
| void write(int c)                                  | 写一个字符             |
| void write(String str)                             | 写一个字符串           |
| void write(String str, int off, int len)           | 写一个字符串的一部分。 |

###### 4.1常用字符流

1）转换流（OutputStreamWriter、InputStreamReader）

```
/**
 * 字符输出转换流
 * 1。   构造器
 *          OutputStreamWriter(OutputStream out,String charsetName)
 *          -:  指定字符集写数据
 *          OutputStreamWriter(OutputStream out)
 *          -:  使用系统默认字符集写数据，通常为UTF-8
 * 小提示：文件字节流中的路径，如果是相对路径，则相对的是项目名称这个文件夹
 * */
public class OutputStreamWriterDemo01 {
    public static void main(String[] args) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(".\\SE_day07\\a.txt",true),8192),"utf-8");
            //写一个字符
            osw.write("中");
            osw.write("国");
            //写一串字符
            char[] charArray = "是伟大的".toCharArray();
            osw.write(charArray);
            //写一个字符串
            osw.write("发展中国家a");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

```
/**
 * 字符输入转换流
 * 1。   构造器
 *          InputStreamReader(InputStream in,String charsetName)
 *          基于给定的字节输入流以及字符集创建字符输入流
 *          InputStreamReader(InputStream in)
 *          该构造方法会根据系统默认字符集创建字符输入流
 * */
public class InputStreamRiderDemo01 {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(".\\SE_day07\\a.txt"),8192));
            int read = isr.read();
            System.out.println((char)read);
            char[] chs = new char[20];
            int read1 = isr.read(chs);
            System.out.println(new String(chs,0,read1));
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

2)缓冲字符流（PrintWriter、BufferedRider）

```
/**
 * 缓冲字符输出流：
 * 1.   一般使用PrintWriter，二不是BufferedWriter，因为前者的功能更强大
 * 2.   构造器
 *          --使用默认字符集写数据
 *              - PrintWriter(OutputStream out)
 *              - PrintWriter(OutputStream out,boolean autoFlush)
 *          --使用指定字符集写数据
 *              - PrintWriter(Writer writer)
 *              - PrintWriter(Writer writer,boolean autoFlush)
 * 3.   ln结尾的方法，每写一行，都会在末尾添加一个换行符号。
 * */
public class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(".\\SE_day07\\b.txt"), "utf-8"),true);
            pw.println("你是最棒的");
            pw.println("你干嘛~哈哈~哎呦");
            pw.println("man");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                pw.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

```
/**
 * 缓冲字符输入流：BufferedRider
 * 1    内部也是维护了一个缓冲区的。  磁盘的数据尽可能一次性的多存储到缓冲区里
 *      方法从缓冲区再次取数据
 * 2    构造器
 *          --使用指定字符集进行读取
 *              - BufferedReader(Reader reader)
 * 3.   readLine()方法读到文件末尾时，再次读取返回的是null。
 * */
public class BufferedRiderDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(".\\SE_day07\\b.txt"),"utf-8"),8192);
            String string = br.readLine();//读到换行符，但是不包含换行符
            System.out.println(string);
            string = br.readLine();
            System.out.println(string);
            string = br.readLine();
            System.out.println(string);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

3）文件字符流（FileWriter、FileReader）

```
/**
 * try-with-resource写法
 * 1.   是finally模块里通常要进行流关闭的简单写法
 * 2.   如果要使用简写，流必须实现AutoCloseable接口或者其子类
 * 3.   写法
 *      try(代码片段){
 *
 *         }catch (Exception e) {
 *             e.printStackTrace();
 *         }
 *         - 省略finally模块
 *         - 代码片段是流对象的定义，需要关闭的流必须在该代码片段里
 * 4.   该简写会在流任务完成后自动关闭流对象
 * */
public class FileWriterDemo {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(".\\SE_day07\\c.txt")){
            fw.write('A');
            fw.write("中国");
            fw.write("蔡徐坤");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```
public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(".\\SE_day07\\c.txt")){
            int read = fr.read();
            System.out.println((char)read);
            char[] chs = new char[10];
            int read1 = fr.read(chs);
            System.out.println(new String(chs,0,read1));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

4）其他流（System.out、System.in、System.err）

```
/**
 * 1.   out是System的静态属性，是PrintStream类型，字节输出流。
 * 2.   查看某一个对象的类名，变量.class.getName();
 * 3.   PrintStream对象的目标位置是console(控制台)
 */
public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(System.out.getClass().getName());//out对象调用println方法将数据写到console窗口
        //使用out将数据写到d.txt里。
        PrintStream oldAddress = System.out; //临时保存原有流对象的地址
        System.setOut(new PrintStream(new FileOutputStream("d.txt")));
        System.out.println("hello world");
        System.out.println("ABCDEFG");
        System.out.println("AAA建材批发王总");
        System.out.println("你怎么这么自私~呸");
        System.out.println("装B我给你飞起来");
        //改回原有的效果
        System.setOut(oldAddress);
        System.out.println("hello world");

        //System.in是一个字节输入流，数据源是键盘
        InputStream old2 = System.in;
        //修改in这个静态属性的指为一个文件字节输入流
        System.setIn(new FileInputStream("d.txt"));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        //err与out流功能相似，只不过err输出的数据带有警告颜色
        //因此某些输出语句想要做到一个警告提醒的行为时，可以使用err

        System.err.println("神鹰黑手哥");
    }
}
```