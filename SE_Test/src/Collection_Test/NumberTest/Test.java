package Collection_Test.NumberTest;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random()*30 + 1));
        }
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> newList = new ArrayList<>(list);
        System.out.println(newList);
        int count = 0;
        ListIterator<Integer> iterator = newList.listIterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number > 10){
                System.out.print(number + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
