package Collection_Test.EmployeeTest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee("张三",18,5,1000.0);
        Employee emp2 = new Employee("李四",19,6,2000.0);
        Employee emp3 = new Employee("王五",20,7,3000.0);
        Employee emp4 = new Employee("赵六",21,6,2500.0);
        Employee emp5 = new Employee("吴七",20,8,1500.0);
//        Set<Employee> empSet = new TreeSet<>();
//        empSet.add(emp1);
//        empSet.add(emp2);
//        empSet.add(emp3);
//        empSet.add(emp4);
//        empSet.add(emp5);
//        for (Employee emp : empSet) {
//            System.out.println(emp);
//        }
        Set<Employee> empSet = new TreeSet<>(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() == o2.getAge() ? (int) (o1.getWorkAge() == o2.getWorkAge()? ( o2.getSalary() - o1.getSalary()) : (o2.getWorkAge() - o1.getWorkAge())) : (o1.getAge() - o2.getAge());
            }
        });
        empSet.add(emp1);
        empSet.add(emp2);
        empSet.add(emp3);
        empSet.add(emp4);
        empSet.add(emp5);
        for (Employee emp : empSet) {
            System.out.println(emp);
        }
    }
}
