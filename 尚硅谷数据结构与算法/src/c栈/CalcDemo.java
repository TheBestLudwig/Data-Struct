package c栈;

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
//        System.out.print("请输入算式：");
//        Scanner sc = new Scanner(System.in);
//        String s = null;
//        if (sc.hasNext()){
//            s = sc.next();
//            System.out.println(s);
//        }
//        String calc = "78+9*6+3*2";
 /*       String regStr1 = "[\\+\\-\\*\\/]";
        String regStr2 = "[0-9]+";

        String[] ss1 = calc.split(regStr1);
        String[] ss2 = calc.split(regStr2);

        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opeStack = new ArrayStack2(10);
        for (int i = 0; i < ss1.length; i++) {
            if (ss1[i].isEmpty()) break;
            numStack.push(Integer.parseInt(ss1[i]));
            if (ss2[i].isEmpty()) break;
            opeStack.push(ss2[i]);


        }
        while (!numStack.isEmpty()) {
            System.out.println(numStack.pop());
        }
        while (!opeStack.isEmpty()) {
            System.out.println(opeStack.pop());
        }


        //2.遍历算式
*/
    String calc = "78+9*6+3*2";
    String s = "";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opeStack = new ArrayStack2(10);
        for (int i = 0; i <calc.length() ; i++) {
            if (isDigit(calc.charAt(i))){
                s += String.valueOf(calc.charAt(i));
            }
            numStack.push(Integer.parseInt(s));
            System.out.println(s);
            s = "";
        }

    }

    static boolean isOper(char c){
        return c == ('+'|'-'|'*'|'/');
    }
    static boolean isDigit(char c){
        return c == ('1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'0');
    }
}

class ArrayStack2 {
    private final int maxSize;
    private final int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
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
