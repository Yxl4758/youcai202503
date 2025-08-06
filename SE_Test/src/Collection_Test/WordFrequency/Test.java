package Collection_Test.WordFrequency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String str = "Hello world, hello Java. World of Java!";
        wordFrequency(str);
    }
    public static void wordFrequency(String str) {
        Map<String,Integer> map = new LinkedHashMap<>();
        String words = str.replaceAll("[,\\.!]","").toLowerCase();
        String[] wordArray = words.split(" ");
        for (int i = 1; i <= wordArray.length; i++) {
            if (!map.containsKey(wordArray[i - 1])) {
                map.put(wordArray[i - 1], 1);
            } else {
                map.replace(wordArray[i - 1], map.get(wordArray[i - 1]) + 1);
            }
        }
        System.out.println(map);
    }
}
