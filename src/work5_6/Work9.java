package work5_6;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:692. 前K个高频单词
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 20:28
 */
public class Work9 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words) {
            if(map.containsKey(s)) {
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1).equals(map.get(o2))) {
                    return o2.compareTo(o1);
                }else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });
        for(String s : map.keySet()) {
            queue.offer(s);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        List<String> list = new ArrayList<>(k);
        while (queue.size() > 0) {
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }

}
