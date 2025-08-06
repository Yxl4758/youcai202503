package com.youcai.day03._01Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试groupCount()
 * */
public class RegexDemo04 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(((c)a)(t))s");
        Matcher matcher = pattern.matcher("one cat, two cats in the yard");
        /**
         * int groupCount():
         * 作用：用于获取正则表达式中的小括号的个数。() 用于分组。
         */
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            // 打印符合正则表达式的子串， 因此循环次数是xxxx次。
            System.out.println(matcher.group());
        }
        /**
         * 使用小括号的个数来循环, 可以使用group的重载方法：
         * String group(int group)
         *
         * 注意：想要使用()的个数进行遍历，需要将指针移动到字符串之前，然后还需要调用一下find方法
         * find()执行后，指针指向的那个子串进行操作
         * group(0): 表示的是对组进行拆分括号的整体的样子
         * group(1): 表示第一个括号
         * group(2): 表示第二个括号
         * 当指针指向某一个子串时会将该字串按照正则表达式进行分组，并保存起来
         *      第一组；组号是0，表示去掉所有括号的样子
         *      第二组：组号是1，表示第一个括号
         *      第三组：组号是2，表示第一个括号
         *   从第二组开始，所有被的括号的开始符号从左到右依次分配组号
         */
        matcher.reset();
        matcher.find();
        for (int i = 0; i <=matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }
    }
}
