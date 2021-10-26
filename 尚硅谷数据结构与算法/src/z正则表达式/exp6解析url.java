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
        String regStr = "^([a-zA-Z]+)://([A-Za-z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        String content = "http://www.sohu.com:8080/abc/index.htm";
        Pattern p = Pattern.compile(regStr);
        Matcher m = p.matcher(content);
        if (m.matches()){
            System.out.println("匹配成功");
            System.out.println("协议："+m.group(1));
            System.out.println("域名："+m.group(2));
            System.out.println("端口："+m.group(3));
            System.out.println("文件名："+m.group(4));
        }else {
            System.out.println("匹配失败");
        }
    }
}
