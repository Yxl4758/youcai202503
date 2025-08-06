package CollectionStream_Test.Test02;

public class Student<T> {
    private String name;
    private int age;
    T score;
    public Student(String name, int age, T score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "年龄：" + age  + "成绩：" + score + '}';
    }
}
