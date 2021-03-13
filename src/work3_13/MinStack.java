package work3_13;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * User: starry
 * Date: 2021 -03 -13
 * Time: 16:40
 */
public class MinStack {
    Stack<Integer> a;
    Stack<Integer> b;

    /** initialize your data structure here. */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        if(a.empty() || x <= b.peek()) {
            a.push(x);
            b.push(x);
        }else {
            a.push(x);
        }
    }

    public void pop() {
        if(a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }

    public static void main(String[] args) {
        MinStack a = new MinStack();
        a.push(512);
        a.push(-1024);
        a.push(-1024);
        a.push(512);
        a.pop();
        a.getMin();
        a.pop();
        a.getMin();
        a.pop();
        a.getMin();
    }
}