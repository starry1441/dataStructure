package Work3_12;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * User: starry
 * Date: 2021 -03 -12
 * Time: 20:29
 */

public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //谁不为空入到哪个队列中
        if(q1.isEmpty() && q2.isEmpty()){
            q1.offer(x);
            return;
        }
        if(!q1.isEmpty()) {
            q1.offer(x);
        }
        if(!q2.isEmpty()) {
            q2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //每次出不为空的队列，出size-1个，到另一个为空的队列，最后弹出剩余的那个元素
        if(q1.isEmpty() && q2.isEmpty()) return -1;
        if(!q1.isEmpty()){
            int i = 1;
            int len = q1.size();
            while(i < len) {
                int en = q1.poll();
                q2.offer(en);
                i++;
            }
            return q1.poll();
        }
        if(!q2.isEmpty()){
            int i = 1;
            int len = q2.size();
            while(i < len) {
                int en = q2.poll();
                q1.offer(en);
                i++;
            }
            return q2.poll();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if(q1.isEmpty() && q2.isEmpty()) return -1;
        if(!q1.isEmpty()){
            int i = 0;
            int en = 0;
            int len = q1.size();
            while(i < len) {
                en = q1.poll();
                q2.offer(en);
                i++;
            }
            return en;
        }
        if(!q2.isEmpty()){
            int i = 0;
            int en = 0;
            int len = q2.size();
            while(i < len) {
                en = q2.poll();
                q1.offer(en);
                i++;
            }
            return en;
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack a = new MyStack();
        a.push(1);
        a.push(2);
        a.top();
    }
}