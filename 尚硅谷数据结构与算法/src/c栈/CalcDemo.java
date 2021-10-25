package c栈;

import javax.xml.stream.events.Characters;
import java.util.Scanner;

/**
 * 1.得到算式
 * 2.遍历算式，取出当前字符，如果是数字，则入数字栈，是符号则分情况
 *  2.1符号栈为空，直接入栈
 *  2.2符号栈不空，如当前符号优先级大于符号栈顶符号，则数字栈弹出2个数，用当前符号运算，结果存入数字栈
 *  2.3符号栈不空，如当前符号优先级小于符号栈顶符号，则直接入符号栈
 * 3.算式遍历完后，数字栈中弹出2数，用符号栈中弹出的符号运算，结果入数字栈，直到符号栈中只有一个数字
 *
 */
public class CalcDemo {
    public static void main(String[] args) {
        //1.得到算式
        System.out.print("请输入算式：");
        Scanner sc = new Scanner(System.in);
        String s = null;
        if (sc.hasNext()){
            s = sc.next();
            System.out.println(s);
        }
        //2.遍历算式
        String num = "";
        for (int i = 0; i <s.length() ; i++) {
            if (Character.isDigit(s.charAt(i)))
                num += s.charAt(i);
           ////
        }

    }
}

class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int data){
        if (isFull())return;
        stack[++top] = data;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show(){//遍历时从栈顶显示
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
