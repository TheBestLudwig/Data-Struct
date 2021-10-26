package z正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.sohu.com:8080/abc/index.htm
 * 1.协议 http
 * 2.域名     www.sohu.com
 * 3.端口     8080
 * 4.文件名    index.htm
 * 思路：分组获得，通过：/.来进行分组
 */


public class exp6解析url {
    public static void main(String[] args) {
        String regStr = "[/://.]";
        String content = "http://www.sohu.com:8080/abc/index.htm";
        Pattern p = Pattern.compile(regStr);
        Matcher m = p.matcher(content);
        String[] split = content.split("/|:|\\.");
        for (String s :split){
            System.out.println(s);
        }
    }
}
