package Work4_22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -22
 * Time: 9:22
 */
public class Work1 {

    public static void topK(int[] arr,int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i = 0; i < arr.length; i++) {
            if(i < k) {
                queue.offer(arr[i]);
            }else {
                int top = queue.peek();
                if(arr[i] > top) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        for(int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        topK(new int[]{27,15,19,18,28,34,65,49,25,37},3);
    }

}
