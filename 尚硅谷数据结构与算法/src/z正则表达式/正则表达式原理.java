package z正则表达式;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式原理 {
    public static void main(String[] args) {
        String content = "2008main方法，正如注释所说，这是程序开始" +
                "执行的第一行。对于一个Java应用程序来说，main" +
                "方法是必需的，Java解释器在没有生成任何对象的" +
                "情况下，以main作为入口来执行程序。每个类中可" +
                "以定义多个方法，但main方法只能有一个。关键字" +
                "public表示访问权限，指明所有的类都可以使用" +
                "这一方法。本1991例中，main必须被定义为public类" +
                "型，因为当程序开始执行时它需要被它的类之外" +
                "的代码调用。关键字static指明该方法是一个" +
                "类方法。关键字void指明main()方法不返回任" +
                "何值。main方法圆括号中定义的String args" +
                "[]是传送给main9889方法的参数，参数名为args，" +
                "它是类String的一个对象。方法的参数用“类" +
                "名参数名”来指定，多个参数间用逗号分隔。" +
                "该行的最后一个字符3003是“{”，它表示了main程" +
                "序体的开始，一个方法中包含的所有代码都将" +
                "包括在这对花括号中间。另外，main仅是解释" +
                "器开始工作的地方，一个复杂的程序可能包含几" +
                "十个类，但这些类仅需要一个main方法。";
        String regStr = "\\d\\d\\d\\d";//匹配所有四个数字
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
        /**
         * 一、matcher.find()做了什么？
         * 1.根据指定规则，定位满足规则的子字符串（比如2008）
         * 2.找到后，将子字符串开始的索引记录到matcher对象的int[] groups属性中
         *  group[0] = 0,把该字符串结束的索引+1的值记录到group[1] = 4
         * 3.同时记录oldLast值为子字符串结束的索引+1的值，即4，即为下次执行find时，就从4开始匹配
         *
         * 二、matcher.group(0);
         *    public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *  1.group[0]=0 和group[1]=4的记录位置，从content开始截到子字符串返回（不包括group[1]）
         *
         *
         */


    }
}
