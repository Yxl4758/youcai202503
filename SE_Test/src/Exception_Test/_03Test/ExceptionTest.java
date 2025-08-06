package Exception_Test._03Test;

public class ExceptionTest {
    public static void main(String[] args) throws Exception {
        String[] str = {null,"123"};

        try {
            Person.strProcess(str);
        }catch (Exception e){
            e.fillInStackTrace();
        }

        try {
            for(int i=0;i<str.length;i++){
                System.out.println(str[i]);
            }
        }catch (NullPointerException e){
            throw new RuntimeException("空指针");
        }
    }
}
class Person{
    public static void strProcess(String[] str){
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }
}
