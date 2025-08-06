package Regular_Test._02Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person[] persons = new Person[5];
        persons[0] = new Person("张三",28,"Yxl4758@163.com");
        persons[1] = new Person("李四",-178,"Yxl4758163.com");
        persons[2] = new Person("啊腹黑附件",28,"Yxl4758@.com");
        persons[3] = new Person("王五",89,"Yxl4758@163.com");
        persons[4] = new Person("张三",0,"Yxl4758@163.com");
        System.out.println(persons[0]);
        for (int i = 0; i < persons.length; i++) {
            if(checkInfo(persons[i])){
                personList.add(persons[i]);
            }
        }
        System.out.println(personList);
    }
    public static boolean checkInfo(Person person){
        String regex = "[\\u4e00-\\u9fa5]{2,4},[2-9]{2},[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(person.toString());
        System.out.println(matcher.matches());
        return matcher.matches();
    }
}
