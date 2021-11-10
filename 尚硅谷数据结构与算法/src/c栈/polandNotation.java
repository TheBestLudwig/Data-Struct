package c栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class polandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        String suffixExp = "3 4 + 5 * 6 - ";

        //1.先将suffixExp装入一个ArrayList中
        //2.将ArrayList传给一个方法，配合栈完成计算
        List<String> list = getListString(suffixExp);
        System.out.println("算式为：" + list);
        int res = calculate(list);
        System.out.println("计算结果为:" + res);

    }

    //将逆波兰式依次放入ArrayList中
    public static List<String> getListString(String suffixExp) {
        //将suffixExp分割
        String[] split = suffixExp.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰式的计算
    public static int calculate(List<String> ls) {
        //创建一个栈，此时只需一个栈
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {//匹配多位数
                stack.push(item);
            } else {
                //弹出两个数并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }


}
