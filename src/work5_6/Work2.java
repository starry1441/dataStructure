package work5_6;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:list当中存放的数据为10万个，找出第一个重复的数据
 * User: starry
 * Date: 2021 -05 -06
 * Time: 17:03
 */
public class Work2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
        System.out.println(list);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if(set.contains(list.get(i))) {
                System.out.println(list.get(i));
                break;
            }else {
                set.add(list.get(i));
            }
        }
    }

}
