package work3_13;

/**
 * Created with IntelliJ IDEA.
 * Description:循环队列
 * User: starry
 * Date: 2021 -03 -13
 * Time: 11:40
 */
public class MyCircularQueue {
    public int[] arr;
    public int rear;    //队尾
    public int front;   //队首
    public int len;

    public MyCircularQueue(int k) {
        arr = new int[k+1];
        len = k+1;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        arr[rear%len] = value;
        rear++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        front++;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return arr[front%len];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return arr[(rear-1)%len];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear+1)%len == (front)%len;
    }
}