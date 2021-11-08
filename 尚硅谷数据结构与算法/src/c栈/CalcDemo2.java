package c栈;
//跟老师的版本

/**
 * 1.得到算式
 * 2.遍历算式，取出当前字符，如果是数字，则入数字栈，是符号则分情况
 * 2.1符号栈为空，直接入栈
 * 2.2符号栈不空，如当前符号优先级大于符号栈顶符号，则数字栈弹出2个数，用当前符号运算，结果存入数字栈
 * 2.3符号栈不空，如当前符号优先级小于符号栈顶符号，则直接入符号栈
 * 3.算式遍历完后，数字栈中弹出2数，用符号栈中弹出的符号运算，结果入数字栈，直到符号栈中只有一个数字
 */
public class CalcDemo2 {
    public static void main(String[] args) {

        String calc = "3+2*6-4";
        int index = 0;
        char ch = ' ';
        int oper = 0;
        int num1, num2, num3;
        ArrayStack3 numStack = new ArrayStack3(10);
        ArrayStack3 opeStack = new ArrayStack3(10);

        while (index < calc.length()) {
            //先依次得到calc的每一个字符
            //ch = calc.charAt(index);
            ch = calc.substring(index, index + 1).charAt(0);
            if (!opeStack.isOper(ch)) {
                int num = Integer.parseInt(ch + "");
                numStack.push(num);
            } else {
                if (opeStack.isEmpty()) {
                    opeStack.push(ch);
                } else if (numStack.priority(ch) > numStack.priority(opeStack.peek())) {
                    opeStack.push(ch);
                } else if (numStack.priority(ch) <= numStack.priority(opeStack.peek())) {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    num3 = numStack.calc(num2, num1, (char) opeStack.peek());
                    numStack.push(num3);
                }
            }
            index++;
        }
        //下面的计算又是一个循环
        num1 = numStack.pop();
        num2 = numStack.pop();
        ch = (char) opeStack.pop();
        num3 = numStack.calc(num2, num1, ch);
        numStack.push(num3);
        num1 = numStack.pop();
        num2 = numStack.pop();
        ch = (char) opeStack.pop();
        num3 = numStack.calc(num2, num1, ch);
        numStack.push(num3);
        System.out.println(numStack.peek());


    }


}

class ArrayStack3 {
    private final int maxSize;
    private final int[] stack;
    private int top = -1;

    public ArrayStack3(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isFull()) return;
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {//遍历时从栈顶显示
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    public int peek() {//返回顶部数据，但不弹出
        return stack[top];
    }

    //返回运算符的优先级,数字越大，则优先级越高,目前只有+-*/
    public int priority(int oper) {
        if (oper == '*' || oper == '/') return 2;
        else if (oper == '+' || oper == '-') return 1;
        else return -1;
    }

    //判断扫描到的是不是运算符
    public boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int calc(int num1, int num2, char ch) {
        int temp = 0;
        switch (ch) {
            case '+':
                temp = num1 + num2;
                break;
            case '-':
                temp = num1 - num2;
            case '*':
                temp = num1 * num2;
            case '/':
                try {
                    temp = num1 / num2;
                } catch (ArithmeticException e) {
                    System.out.println("除数不能为0");
                }
                break;
            default:
                System.out.println("算式有错");
        }
        return temp;
    }
}
