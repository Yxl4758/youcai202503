package Collection_Test.CharTest;

import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = sc.next();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.add(c);
        }
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        StringBuilder str = new StringBuilder();
        while (left != list.size()) {
            if (list.get(left) == list.get(right)) {
                str.append(list.get(left)).append("(").append(right - left + 1).append(")");
                left = right + 1;
                right = list.size();
            }
            right--;
        }
        System.out.println(str);
    }
}
