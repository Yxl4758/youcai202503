package Regular_Test._01Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular02 {
    public static void main(String[] args) {
//        String url = "https://www.rcnpa2s7yjdz.feishu.cn/wiki/LytWwv6XOibc3hkx6JJcrSwinKf";
//        StringBuilder urlInfo = new StringBuilder();
//        urlInfo = urlGetInfo(url);
//        System.out.println(urlInfo);
        String string = "you are#the_best";
        string = stringFormat(string);
        System.out.println(string);

    }
    // 提取URL信息：编写程序从文本中提取所有的URL链接，并分别提取协议、
    // 域名和路径部分。使用正则表达式的分组捕获功能。
    public static StringBuilder urlGetInfo(String str){
        StringBuilder sb = new StringBuilder();
        String regex = "(https?|ftp)://(([a-z0-9]([a-z0-9-]*[a-z0-9])?\\.)+[a-z]{2,})(/[\\w\\-\\.~!*'();:@&=+$,\\/?%#\\[\\]]*)?";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(str);
        matcher.reset();
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        matcher.reset();
        matcher.find();

        for (int i = 1; i <= matcher.groupCount(); i++) {
            if(i == 3 || i == 4){
                continue;
            }
            sb.append(matcher.group(i));
            i++;
        }
        return sb;
    }
    //9. 字符串格式化处理
    public static String stringFormat(String str){
        String regex = "[\\s|#_$@&*^]";
        str = str.replaceAll(regex, " ");
        return str;
    }
}
