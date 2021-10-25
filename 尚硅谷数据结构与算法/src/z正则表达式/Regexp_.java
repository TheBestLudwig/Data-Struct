package z正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: jeff
 * @Date: 2021/10/18 - 10 - 18 - 21:35
 * @Description: z正则表达式
 * @version: 1.0
 */
public class Regexp_ {
    public static void main(String[] args) {


        //假定编写了爬虫，从百度页面得到如下文本
        String content = "1995年，互联网的蓬勃发展给了Oak机会。" +
                "业界为了使死板、单调的静态网页能够“灵活”起来，急需" +
                "一种软件技术来开发一种程序，这种程序可以通过网络传播并" +
                "且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量" +
                "的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来" +
                "很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它" +
                "是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，" +
                "特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，" +
                "适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页" +
                "在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行" +
                "的技术），并将Oak更名为Java（在申请注册商标时，发现Oak已经被人" +
                "使用了，再想了一系列名字之后，最终，使用了提议者在喝一杯Java咖" +
                "啡时无意提到的Java词语）。5月23日，Sun公司在Sun world会议上正式" +
                "发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、" +
                "Netscape和微软等各大公司都纷纷停止了自己的相关开发项目，竞相购买" +
                "了Java使用许可证，并为自己的产品开发了相应的Java平台。 [9-10] ";
        //需求：提取文章中所有英文单词
        //思路：   （1）传统方法：遍历方式，代码量大，效率不高
        //         （2）正则表达式技术

        //1.先创建一个Pattern对象，模式对象，可以理解为一个正则表达式对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //2.创建一个匹配对象
        //理解：匹配器matcher匹配器按照pattern（模式/样式），到content文本中去匹配，找到就true,否则返回false
        Matcher matcher = pattern.matcher(content);
        //3.可以开始循环匹配
        while (matcher.find()) {
            //匹配内容，文本放到m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }


    }
}
