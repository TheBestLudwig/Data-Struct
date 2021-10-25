package z正则表达式;

import java.util.regex.Pattern;

/**
 * 演示matches方法，用于整体匹配，在验证输入的字符串是否满足条件使用
 */
public class PatternMethod {
    public static void main(String[] args) {
        String content = "I am cjf from cjf-cao.com";
        String regStr1 = "cjf";//false
        String regStr2 = ".*cjf.*";//true,此法可不必像下面一样全部写出来
        String regStr3 = "I am cjf from cjf-cao.com";//true
        Boolean isMache1 = Pattern.matches(regStr1, content);
        Boolean isMache2 = Pattern.matches(regStr2, content);
        Boolean isMache3 = Pattern.matches(regStr3, content);

        System.out.println(isMache1);//不会返回匹配的内容，只会返回真假
        System.out.println(isMache2);
        System.out.println(isMache3);

    }
}
