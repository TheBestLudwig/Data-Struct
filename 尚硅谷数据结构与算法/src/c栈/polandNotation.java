package c栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class polandNotation {
    public static void main(String[] args) {
/*
        //先定义一个逆波兰表达式
        String suffixExp = "3 4 + 5 * 6 - ";

        //1.先将suffixExp装入一个ArrayList中
        //2.将ArrayList传给一个方法，配合栈完成计算
        List<String> list = getListString(suffixExp);
        System.out.println("算式为：" + list);
        int res = calculate(list);
        System.out.println("计算结果为:" + res);
*/
        String expression = "1+((2+3)*4)-5";
        //1.直接对字符串操作不方便，先将表达式转List
        List<String> infixExpList = toInfixExpList(expression);
        System.out.println(infixExpList);
        //2.List转后缀
        //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]==>[1,2,3,+,4,*,5,-]
        List<String> parseSuffixExpList = parseSuffixExpList(infixExpList);
        System.out.println(parseSuffixExpList);

        System.out.printf("expression=%d", calculate(parseSuffixExpList));
    }

    public static List<String> toInfixExpList(String s) {//中缀转List
        //定义一个List存放中缀表达式对应内容
        List<String> ls = new ArrayList<String>();
        int i = 0;//索引
        String str;//对多位数的拼接
        char c;//每遍历一个字符，则放入c中
        do {
            //如果c是非数字，则需要加入ls里，
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                //如果是数，则要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    public static List<String> parseSuffixExpList(List<String> ls) {
        //1.定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //因为S2栈在整个过程中没有pop操作，而且还要逆序，麻烦，直接使用List
        List<String> s2 = new ArrayList<String>();
        //遍历ls
        for (String item : ls) {
            //如果是一个数，就入数栈S2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号，则依次弹出S1栈顶的运算符，并压入S2，直到遇到括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将左小括号弹出S1栈
            } else {
                //当item优先级小于等于栈顶运算符的优先级，将s1栈顶运算符弹出并加入S2中，再转4.2与s1中新栈顶运算符比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;//因为是存放到List中，可以不用倒序
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


//编写一个类Operation,可以返回一个运算符对应的优先级
class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    //写一个方法返回优先级对应数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}

/**
 *
 ****/
