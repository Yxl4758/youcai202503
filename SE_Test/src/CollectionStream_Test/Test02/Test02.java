package CollectionStream_Test.Test02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test02 {
    Stream<Student> stream;
    List<Student> students;
    @Before
    public void init(){
        students = new ArrayList<>();
        Student stu1 = new Student<>("micheal",26,98.5);
        Student stu2 = new Student<>("tom",17,90.5);
        Student stu3 = new Student<>("lily",20,89.5);
        Student stu4 = new Student<>("lucy",18,83.5);
        Student stu5 = new Student<>("cxk",23,100);
        Student stu6 = new Student<>("崔晓洋",25,78);
        Student stu7 = new Student<>("李晓宇",24,63);
        Student stu8 = new Student<>("刘孟达",19,68);
        Student stu9 = new Student<>("柳梦璃",22,28);
        Student stu10 = new Student<>("韩菱纱",21,48.5);
        students.addAll(Arrays.asList(stu1,stu2,stu3,stu4,stu5,stu6,stu7,stu8,stu9,stu10));
        stream = students.stream();
    }

    @Test
    public void ageFilter() {
        stream.filter(stu -> stu.getAge() > 18 && stu.getAge() < 25).forEach(System.out::println);
    }

}
