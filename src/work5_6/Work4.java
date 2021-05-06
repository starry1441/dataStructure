package work5_6;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:将10万个数据，统计重复数字及出现的次数
 * User: starry
 * Date: 2021 -05 -06
 * Time: 17:12
 */
public class Work4 {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 10_0000; i++) {
            int tmp = list.get(i);
            if(map.containsKey(tmp)) {
                map.put(tmp,map.get(tmp)+1);
            }else {
                map.put(tmp,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }

}
