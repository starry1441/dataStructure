package work3_13;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * User: starry
 * Date: 2021 -03 -13
 * Time: 15:54
 */
public class Work3 {

    Stack<Integer> a;
    Stack<Integer> b;

    /** Initialize your data structure here. */
    public void MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(b.empty()) {
            int size = a.size();
            for(int i = 0; i < size; i++) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(b.empty()) {
            int size = a.size();
            for(int i = 0; i < size; i++) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.empty() && b.empty();
    }

}
