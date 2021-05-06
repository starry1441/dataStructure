package work5_6;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 20:24
 */
public class Work5 {

    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        for(int i : set) {
            return i;
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

}
