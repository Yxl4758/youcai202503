package Collection_Test.EmployeeTest;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private int workAge;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, int workAge, double salary) {
        this.name = name;
        this.age = age;
        this.workAge = workAge;
        this.salary = salary;
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

    /**
     * 获取
     * @return workAge
     */
    public int getWorkAge() {
        return workAge;
    }

    /**
     * 设置
     * @param workAge
     */
    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    /**
     * 获取
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "姓名：" + name + ", 年龄：" + age + ", 工龄：" + workAge + ", 薪资：" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && workAge == employee.workAge && Double.compare(salary, employee.salary) == 0 && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workAge, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return this.age == o.age ? (int) (this.workAge == o.workAge ? ( o.salary - this.salary) : (o.workAge - this.workAge)) : (this.age - o.age);
    }
}
