package work5_6;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:771. 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 20:25
 */
public class Work7 {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
