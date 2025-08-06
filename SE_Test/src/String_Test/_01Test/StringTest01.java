package String_Test._01Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest01 {
    public static void main(String[] args) {
//        String string = "ab A";
//        System.out.println("palindrome(string) = " + palindrome(string));

//        String string = "ab";
//        List<String> list = sumChar(string);
//        System.out.println(list);

//        String str = "hello world";
//        str = inverWord(str);
//        System.out.println(str);

        String str1 = "acbscfghbscac";
        String str2 = "bsc";
        List<int []> list;
        list = subStringIndex(str1,str2);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
    //判断回文串
    public static boolean palindrome(String str){
        str = str.toLowerCase().replaceAll(" ","");
        StringBuffer sb = new StringBuffer(str).reverse();
        return str.contentEquals(sb);
    }
    //统计字符串中每个字符出现的次数
    public static List<String> sumChar(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = chars.length - 1;
        while (left != chars.length){
            if(chars[left] == chars[right]){
                list.add(chars[left] + "出现的次数：" + (right - left + 1));
                left = right + 1;
                right = chars.length;
            }
            right--;
        }
        return list;
    }
    //字符串中的单词顺序颠倒
    public static String inverWord(String str){
        String[] strings = str.split(" ");
        StringBuffer str1 = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            str1.append(strings[i]).append(" ");
        }
        return str1.toString();
    }
    //如何在字符串中查找所有匹配的字串位置
    public static List<int[]> subStringIndex(String string, String substring){
        int index = 0;
        List<int[]> result = new ArrayList<>();
        while (index != -1){
            index = string.indexOf(substring, index);
            if(index != -1){
                result.add(new int[]{index,index + substring.length() - 1});
            }else {
                break;
            }
            index += substring.length();
        }
        return result;
    }
}
