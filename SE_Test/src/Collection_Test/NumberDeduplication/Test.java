package Collection_Test.NumberDeduplication;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
        List<Integer> newList = (List<Integer>) numberDeduplication(list);;
        System.out.println(newList);
    }
    public static List<?> numberDeduplication(List<?> list) {
        List<?> list1 = new ArrayList<>(list);
        List<Object> newList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (!newList.contains(list1.get(i))) {
                newList.add(list1.get(i));
            }
        }
        return newList;
    }
}
