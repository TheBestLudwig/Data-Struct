package z正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod {
    public static void main(String[] args) {
        String content = "I am cjf from cjf-cao.com";
        String regStr = "cjf";//false


        Pattern p = Pattern.compile(regStr);
        Matcher m = p.matcher(content);
        while (m.find()) {
            System.out.println("===============");
            System.out.println(m.start());
            System.out.println(m.end());
            System.out.println("找到：" + content.substring(m.start(), m.end()));
        }
        //整体匹配方法，常用于校验某个字符串是否满足规则
        System.out.println("整体匹配cjf:" + m.matches());

        String content1 = "cjfalfcjfalfjcjfaldfcjf";
        String regStr1 = "cjf";
        Pattern p1 = Pattern.compile(regStr1);
        Matcher m1 = p1.matcher(content1);
        //返回字符串是替换后的串，原串不变，要变可以用content接回来就变了
        String newContent = m1.replaceAll("牛逼");
        System.out.println(newContent);
        System.out.println(content1);
    }
}
