package c栈;


public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack ss = new ArrayStack(10);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
       ss.push(6);
        ss.show();
        ss.pop();
        ss.show();

    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
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