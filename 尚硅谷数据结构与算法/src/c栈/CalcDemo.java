/**

 package c栈;
 //自己做的版本

 public class CalcDemo {
 public static void main(String[] args) {

 String calc = "3+2*6-4";
 int index = 0;
 char ch ;
 char curOper;
 int num1,num2,num3;
 ArrayStack2 numStack = new ArrayStack2(10);
 ArrayStack2 opeStack = new ArrayStack2(10);

 while (index < calc.length()){
 ch = calc.charAt(index);
 if (Character.isDigit(ch)){
 int num = Integer.parseInt(ch+"");
 numStack.push(num);
 }else{
 if(opeStack.isEmpty()){
 opeStack.push(ch);
 }else if(优先级(ch)>opeStack.peek()){
 opeStack.push(ch);
 }else if(优先级(ch) <=opeStack.peek()){
 num1 = numStack.pop();
 num2 = numStack.pop();
 num3 = calc(num2,num1,opeStack.peek());
 numStack.push(num3);
 }
 }
 index++;
 }
 //下面的计算又是一个循环
 num1 = numStack.pop();
 num2 = numStack.pop();
 ch = (char)opeStack.pop();
 num3 = calc(num2,num1,ch);
 numStack.push(num3);




 }
 public static int calc(int num1,int num2,char ch){
 int temp = 0;
 switch (ch){
 case '+':
 temp = num1 + num2;
 break;
 case '-':
 temp = num1 - num2;
 case '*':
 temp = num1 * num2;
 case '/':
 try{
 temp = num1 / num2;
 }catch (ArithmeticException e){
 System.out.println("除数不能为0");
 }
 break;
 default:
 System.out.println("算式有错");
 }
 return temp;
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

 public int peek(){//返回顶部数据，但不弹出
 return stack[top];
 }
 }
 **/