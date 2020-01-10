package p1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 16:53
 * @Author SonnSei
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
