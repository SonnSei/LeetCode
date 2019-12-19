package zero;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution1
 * @Description 两数之和
 * @Date 2019/12/9 8:16
 * @Created by Jesse
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
