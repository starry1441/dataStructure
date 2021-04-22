package work4_20;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:优先级队列---堆
 * User: starry
 * Date: 2021 -04 -20
 * Time: 15:22
 */
public class HeapDemo  {

    public int[] elem;
    public int usedSize;

    public HeapDemo() {
        this.elem = new int[10];
    }

    /**
     * 在这里为什么可以传len
     * 因为每棵树的结束位置实际上都是一样的
     * @param parent
     * @param len
     */
    public void adjustDown(int parent,int len) {
        while(parent*2+1 < len) {
            int left = parent*2+1;
            int right;
            if(left + 1 < len) {
                right = left+1;
            }else {
                right = left;
            }
            int max = elem[left] >= elem[right] ? left : right;
            if(elem[max] > elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[max];
                elem[max] = tmp;
                parent = max;
            }else {
                break;
            }
        }
    }

    public void adjustDown2(int parent,int len) {
        int child = 2*parent+1;

        //child < len 说明没有左孩子
        while (child < len) {
            //child+1 < len 判断是否有有孩子
            if(child+1 < len && this.elem[child] < this.elem[child+1]) {
                child++;
            }
            //child 下标一定是左右孩子的最大值下标
            if(this.elem[child] > this.elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    public void createBigHeap(int[] array) {
        for(int i = 0; i < array.length; i++ ){
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //elem已经存放了元素
        //开始每个父亲节点向下调整
        //已知孩子节点n，父亲节点为（n-1）/2
        for(int i = (this.usedSize-2)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    /**
     * 逻辑：放到数组的最后一个位置
     * 然后向上调整
     * @param child
     */
    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while(child > 0) {
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public void push(int val) {
        //若堆为满，则进行二倍扩容
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[usedSize] = val;
        usedSize++;
        //向上调整
        adjustUp(usedSize-1);
    }

    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        //删除
        //交换首尾位置元素
        int ret = this.elem[0];
        this.elem[0] = this.elem[usedSize-1];
        this.elem[usedSize-1] = ret;
        this.usedSize--;
        adjustDown2(0,usedSize);
        return ret;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return this.elem[0];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public void show() {
        for(int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            int top = elem[0];
            elem[0] = elem[end];
            elem[end] = top;
            adjustDown2(0,end);
            end--;
        }
    }

}


