package work3_13;

/**
 * Created with IntelliJ IDEA.
 * Description:用链表实现栈
 * User: starry
 * Date: 2021 -03 -13
 * Time: 9:59
 */

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    public Node first;
    public Node last;

    //入栈
    public boolean offer(int val) {
        Node node = new Node(val);
        if(this.first == null) {
            this.first = node;
            this.last = node;
        }else {
            this.last.next = node;
            this.last = node;
        }
        return true;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        if(this.first == null && this.last == null) {
            return true;
        }
        return false;
    }

    //出栈
    public int poll() throws RuntimeException{
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int ret = this.first.val;
        this.first = this.first.next;
        return ret;
    }

    //得到队头元素
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.first.val;
    }

}