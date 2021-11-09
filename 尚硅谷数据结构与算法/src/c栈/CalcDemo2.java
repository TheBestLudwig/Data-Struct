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

        String calc = "30+2*6-4";//如何处理多位数？
        int index = 0;
        char ch;
        int oper = 0;
        int num1, num2, num3;
        String keepNum = "";
        ArrayStack3 numStack = new ArrayStack3(5);
        ArrayStack3 opeStack = new ArrayStack3(5);

        while (index < calc.length()) {
            //先依次得到calc的每一个字符
            //ch = calc.charAt(index);
            ch = calc.substring(index, index + 1).charAt(0);
            if (opeStack.isOper(ch)) {//是符号
                if (!opeStack.isEmpty()) {//符号栈不空
                    if (opeStack.priority(ch) > opeStack.priority(opeStack.peek())) {
                        opeStack.push(ch);
                    } else if (opeStack.priority(ch) <= opeStack.priority(opeStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        num3 = numStack.calc(num2, num1, opeStack.pop());
                        numStack.push(num3);
                        opeStack.push(ch);
                    }
                } else {//符号栈为空
                    opeStack.push(ch);
                }
            } else {//不是符号,是数字
//                int num = Integer.parseInt(ch + "");
//                numStack.push(num);

                //numStack.push(ch -48);//如果是多位数，就会出错，按如下方法
                //1.当处理多位数时，不能发现是一个数就立即处栈
                //2.在处理数时，需要向calc表达式的后面再看一位，如果是数，就继续
                //  扫描，如果是符号，才能入栈
                //3.因此，需要定义一个字符串，来用于字符拼接

                keepNum += ch;
                //4.判断下一个字符是不是数字，如果是数，则继续扫描，如是符号，则入数栈。
                //如果ch是最后一位，也是直接入栈
                if (index == calc.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if(opeStack.isOper(calc.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//keepNum用完后要清空，不然会接着拼接
                    }
                }

            }
            index++;
            //如果while中没有条件，则在后面判断
//            if(index >= calc.length()){
//                break;
//            }
        }
        //下面的计算又是一个循环
        while (!opeStack.isEmpty()){//符号栈为空或数栈中只有一个数字，即为判断条件
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = opeStack.pop();
            num3 = numStack.calc(num2, num1, oper);
            numStack.push(num3);
        }
        System.out.println(calc+"="+numStack.peek());

    }


}

//这个栈有问题？
class ArrayStack3 {
    private final int maxSize;
    private final int[] stack;
    private int top = -1;

    public int getTop(){
        return top;
    }

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
    public boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public int calc(int num1, int num2, int oper) {
        int temp = 0;
        switch (oper) {
            case '+':
                temp = num1 + num2;
                break;
            case '-':
                temp = num1 - num2;
                break;
            case '*':
                temp = num1 * num2;
                break;
            case '/':
                if (num2 == 0) System.out.println("除数不能为0");
                temp = num1 / num2;
                break;
            default:
                System.out.println("算式有错");
        }
        return temp;
    }
}
