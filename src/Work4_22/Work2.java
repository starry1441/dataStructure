package Work4_22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -22
 * Time: 10:22
 */
public class Work2 {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> in = new ArrayList<>();
                in.add(nums1[i]);
                in.add(nums2[j]);
                out.add(in);
            }
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1)) - (o1.get(0)+o1.get(1));
            }
        });
        for(int i = 0; i < out.size(); i++) {
            if(i < k) {
                queue.offer(out.get(i));
            }else {
                List<Integer> top = queue.peek();
                if(top.get(0)+top.get(1) > out.get(i).get(0)+out.get(i).get(1)) {
                    queue.poll();
                    queue.offer(out.get(i));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(queue.peek() != null) {
                res.add(queue.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> out = kSmallestPairs(nums1,nums2,k);
        System.out.println(out);
    }

}
