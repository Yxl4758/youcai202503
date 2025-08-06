package String_Test._02Test;

import java.util.Arrays;

public class StringTest02 {
    public static void main(String[] args) {
//        String str = "userName";
//        str = humpTransform(str);
//        System.out.println(str);

//        String str = "aabbccdd";
//        char ch = firstNotRepeatedChar(str);
//        System.out.println(ch);

//        String string = "hello {name}";
//        String string2 = "蔡徐坤";
//        string = replacePlaceholders(string,string2);
//        System.out.println(string);
    }
    //大驼峰转换
    public static String humpTransform(String str){
        StringBuilder builder = new StringBuilder(str);
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                builder.insert(i,'_');
            }
        }
        str = builder.toString();
        return str.toLowerCase();
    }
    //找出字符中第一个不重复的字符
    public static char firstNotRepeatedChar(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int left = 0;
        int right = chars.length - 1;
        while(left < chars.length - 1){
            if(chars[left] == chars[right]){
                left = right+1;
                right = chars.length;
            }
            right--;
            if(left == right){
                return chars[left];
            }
        }
        return '\u0000';
    }
    //占位符替换
    public static String replacePlaceholders(String str1, String str2){
        String regex = "[{]\\w+[}]";
        str1 = str1.replaceAll(regex, str2);
        return str1;
    }
}
