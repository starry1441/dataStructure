package work4_20;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -20
 * Time: 15:44
 */
public class TestDemo {

    public static void main1(String[] args) {
        /**
         * PriorityQueue 堆  优先级队列
         * PriorityQueue 底层 默认是一个小根堆
         * 每次存元素的时候，一定要保证数据进去堆后，依然可以维持为一个小堆/大堆
         * 每次取出一个元素的时候，一定要保证剩下的元素，也要调整为一个小堆/大堆
         */
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.offer(21);
        qu.offer(23);
        qu.offer(2);
        qu.offer(43);
        qu.offer(5);
        qu.offer(8);
        System.out.println(qu.peek());  //2
        qu.poll();
        System.out.println(qu.peek());  //5

    }

    public static void main(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        heapDemo.createBigHeap(array);
        heapDemo.show();
//        heapDemo.push(100);
//        heapDemo.show();
        System.out.println(heapDemo.poll());
        heapDemo.show();
    }

}
