package Collection_Test.AnimalTest;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal("A0001","狸花猫",'公',10);
        Animal animal2 = new Animal("A0002","奶牛猫",'母',12);
        Animal animal3 = new Animal("A0003","哈基米",'公',11);
        Set<Animal> animalSet = new HashSet<Animal>();
        animalSet.add(animal1);
        animalSet.add(animal2);
        animalSet.add(animal3);
        System.out.println(animalSet.size());
    }
}
