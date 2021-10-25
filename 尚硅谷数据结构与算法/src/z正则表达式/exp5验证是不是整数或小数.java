package z正则表达式;

/**
 * 规则：
 * 验证是不是整数或小数
 * 考虑正负数
 * 整数开头不能是0或00，小数可以是0开头
 * 如：123 -356 35.21 -98.6 -0.001 0.45
 */
public class exp5验证是不是整数或小数 {
    public static void main(String[] args) {
        String content = "-01.3";
        String regstr0 = "^[-+]?[1-9]+(\\.)?\\d+$";
        String regstr1 = "^[+-]?([1-9]+\\d+$)|([0-9]+(\\.)?\\d+$)";
        String regstr2 = "^[+-]?([1-9]\\d*)+(\\.\\d+)?$";//0.3不过
        String regstr3 = "^[+-]?([1-9]\\d*|0)+(\\.\\d+)?$";//01.89可过，错
        String regstr4 = "^[+-]?([1-9]\\d*|0)(\\.\\d+)?$";//01.89不可过，对


        if (content.matches(regstr4)) {
            System.out.println("succes");
        } else {
            System.out.println("fail");
        }
    }
}
