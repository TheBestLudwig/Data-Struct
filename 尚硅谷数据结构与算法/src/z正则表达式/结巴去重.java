package z正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 现有结巴字符串："我...我要...学学学学...编程Java!"
 * 要改成正常的串："我要学编程Java!"
 * 思路：
 */
public class 结巴去重 {
    public static void main(String[] args) {
        String content = "我...我要...学学学学...编程Java!";
        //1.去掉所有.
        Pattern p = Pattern.compile("\\.");
        Matcher m = p.matcher(content);
        content = m.replaceAll("");
        System.out.println(content);
        //此时，content = "我我要学学学学编程Java!"
        //2.去掉重复的字
        //（1）使用(.)\\1+可以匹配到：我我，学学学学学
        p = Pattern.compile("(.)\\1+");//分组的捕获内容记录到$1
        m = p.matcher(content);
        while (m.find()) {
            System.out.println("找到：" + m.group(0));
        }
        //(2)使用反向引用 $1来替换匹配到的内容
        content = m.replaceAll("$1");//即用"$1"来替换"(.)\\1+"
        System.out.println(content);
        //3.只用一条语句来去掉重复的字，全面取代2
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");

        System.out.println(content);

    }
}
