package CollectionStream_Test.Test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("michael",20,78);
        Student s2 = new Student("tom",22,59);
        Student s3 = new Student("lily",21,87);
        Student s4 = new Student("lucy",19,98);
        Student s5 = new Student("cxk",18,100);
        Student s6 = new Student("syx",19,72);
        Student s7 = new Student("zzy",20,57);
        Student s8 = new Student("yhx",21,20);
        Student s9 = new Student("hjl",23,75);
        Student s10 = new Student("mjq",20,59);
        List<Student> list = new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10));
        Stream<Student> stream = list.stream();
        //1. 所有及格学生的信息
        //examinationStuInfo(stream);

        //2. 所有及格的学生姓名
        //examinationStuName(stream);

        //3. 所有学生的平均成绩
        //getAverage(stream);

        //4. 班级的前3名(按照成绩)
        //getTheTopThree(stream);

        //5. 班级的3-10名(按照成绩)
        //getExcludeTheTopThree(stream);

        //6. 所有不不及格的学生平均成绩
        //examinationStuAverage(stream);

        //7. 将及格的学生 , 按照成绩降序输出所有信息
        //examinationStuSort(stream);

        //8. 班级学生的总分
        //sumScore(stream);
    }
    //1. 所有及格学生的信息
    public static void examinationStuInfo(Stream<Student> stream){
        Stream<Student> stuStream = stream.filter(stu -> stu.getScore() >= 60);
        stuStream.forEach(System.out::println);
    }
    //2. 所有及格的学生姓名
    public static void examinationStuName(Stream<Student> stream){
        Stream<Student> stuStream = stream.filter(stu -> stu.getScore() >= 60);
        stuStream.forEach(stu -> System.out.print(stu.getName() + "\t"));
    }
    //3. 所有学生的平均成绩
    public static void getAverage(Stream<Student> stream){
        double average = stream.collect(Collectors.averagingDouble(Student::getScore));
        System.out.println("平均成绩为：" + average);
    }
    //4. 班级的前3名(按照成绩)
    public static void getTheTopThree(Stream<Student> stream){
        stream.sorted((stu1,stu2) -> stu2.getScore() - stu1.getScore())
                .limit(3)
                .forEach(System.out::println);
    }
    //5. 班级的3-10名(按照成绩)
    public static void getExcludeTheTopThree(Stream<Student> stream){
        stream.sorted((stu1,stu2) -> stu2.getScore() - stu1.getScore())
                .skip(2)
                .forEach(System.out::println);
    }
    //6. 所有不不及格的学生平均成绩
    public static void examinationStuAverage(Stream<Student> stream){
        Stream<Student> stuStream = stream.filter(stu -> stu.getScore() < 60);
        getAverage(stuStream);
    }
    //7. 将及格的学生 , 按照成绩降序输出所有信息
    public static void examinationStuSort(Stream<Student> stream){
        Stream<Student> stuStream = stream.filter(stu -> stu.getScore() >= 60);
        stuStream.sorted((stu1,stu2) -> stu2.getScore() - stu1.getScore())
                .forEach(System.out::println);
    }
    //8. 班级学生的总分
    public static void sumScore(Stream<Student> stream){
        int sum = stream.mapToInt(Student::getScore).sum();
        System.out.println("总分：" + sum);
    }
}
