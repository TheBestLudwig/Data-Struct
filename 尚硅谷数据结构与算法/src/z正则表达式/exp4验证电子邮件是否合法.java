package z正则表达式;

/**
 * 电子邮件验证规则：
 * 1.只能有一个@
 * 2.@前是用户名，可以是a-z A-Z 0-9 _ -
 * 3.@后是域名，只能为英文字母,如sohu.com
 */
public class exp4验证电子邮件是否合法 {
    public static void main(String[] args) {
        String content = "cjf@yahoo.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        //1.这里String的matches方法是整体匹配
        //2.追String类mathces方法的源码
        /*(1)String类的mathces
        public boolean matches(String regex) {
                return Pattern.matches(regex, this);
            }
         */
        /*(2)Pattern类的matches
        public static boolean matches(String regex, CharSequence input) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            return m.matches();
        }*/
        /*(3)Matcher类的mathces
        public boolean matches() {
            return match(from, ENDANCHOR);
        }试图将整个区域与模式匹配
         */
        if (content.matches(regStr)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }
    }
}
