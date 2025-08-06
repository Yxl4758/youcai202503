package String_Test._03Test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str = "aaAbcBC";
        int count = numberOfSpecialChars(str);
        System.out.println(count);
    }
    public static int numberOfSpecialChars(String word){
        char[] chars = word.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char c : chars){
            set.add(c);
        }
        int count = 0;
        for(char c : set){
            if(set.contains((char)(c + 32))){
                count++;
            }
        }
        return count;
    }
}
