package work5_6;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:list当中有10万个数据，把重复的数字全部都去重
 * User: starry
 * Date: 2021 -05 -06
 * Time: 17:10
 */
public class Work3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
        System.out.println(list);
        Set<Integer> set = new HashSet<>();
        //方式一：
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        System.out.println(set);
        //方式二：
        set.addAll(list);
        System.out.println(set);
    }

}
