package Regular_Test._04Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordBoundary {
    public static void main(String[] args) {
        String words = "java javasprit javaspring java";
        int count = word(words);
        System.out.println(count);
    }
    public static int word(String str){
        String regex = "^java$";
        String[] words = str.split(" ");
        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        for(String word : words){
            Matcher matcher = pattern.matcher(word);
            if(matcher.matches()){
                count++;
            }
        }
        return count;
    }
}
