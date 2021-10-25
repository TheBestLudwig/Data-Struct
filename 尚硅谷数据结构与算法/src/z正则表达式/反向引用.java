package z正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 需求：从文本中找出四位数，且满足14位相同，23位相同，如1221等
 * 1.分组
 * 用圆括号组成一个比较复杂的匹配模式，一组括号为一个组
 * 2.捕获
 * 把正则表达式中子表达式/分组匹配的内容，保存到内存中以数字
 * 编号或显式命名的组里，方便后面引用，从左向右，以分组的
 * 左括号为标志，第一组组号为1，第二组为2，依次类推，组0代表
 * 整个正则式
 * 3.反向引用
 * 圆括号中内容被捕获后，可以在这个括号后被引用，从而写出
 * 一个比较实用的匹配模式。这种引用既可以在正则表达式内部，
 * 也可以在外部，内部反向引用\\分组号，外部反向引用$分组号
 */
public class 反向引用 {
    public static void main(String[] args) {
        String content = "9876 2048, 9999 1991 tom11,jack33,1221,";
        /**
         * 1.两个边续相同的数：(\\d)\\1
         * 2.5个连续相同数：(\\d)\\1{4}
         * 3.个位与千位相同，百位与十位相同数：(\\d)(\\d)\\2\\1
         *
         * */
        //String regstr = "(\\d)\\1";
        //String regstr = "(\\d)\\1{4}";
        String regstr = "(\\d)(\\d)\\2\\1";

        Pattern p = Pattern.compile(regstr);
        Matcher m = p.matcher(content);
        while (m.find()) {
            System.out.println(m.group(0));
        }
        //商品编号：前面一个5位数，后跟一个-，然后是连续3位相同的9位数
        content = "13564-111222333";
        regstr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        p = Pattern.compile(regstr);
        m = p.matcher(content);
        while (m.find()) {
            System.out.println(m.group(0));
        }
    }
}
