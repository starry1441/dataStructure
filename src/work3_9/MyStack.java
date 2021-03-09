package work3_9;

/**
 * Created with IntelliJ IDEA.
 * Description:手撕栈（数组）
 * User: starry
 * Date: 2021 -03 -09
 * Time: 21:02
 */

public class MyStack {
    private int[] elem; //存放栈中元素
    private int top;    //代表下标，也代表当前有多少元素

    //默认开辟大小为10的栈
    public MyStack() {
        this.elem = new int[10];
    }

    //判断栈是否为满
    public boolean isFull() {
        return this.top == this.elem.length;
    }

    //给栈中压入元素
    public int push(int item) {
        if(isFull()) {
            throw new RuntimeException("栈为满");
        }
        this.elem[this.top] = item;
        this.top++;
        return this.elem[this.top-1];
    }

    //弹出栈顶元素
    public int pop() {
        if(empty()) {
            throw new RuntimeException("栈为空");
        }
        this.top--;
        return this.elem[this.top];
    }

    //显示栈顶元素
    public int peek() {
        if(empty()) {
            throw new RuntimeException("栈为空");
        }
        return this.elem[this.top-1];
    }

    //判断栈是否为空
    public boolean empty() {
        return this.top == 0;
    }

    //栈中元素个数
    public int size() {
        return this.top;
    }

}
