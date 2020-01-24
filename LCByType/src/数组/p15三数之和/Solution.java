package 数组.p15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 16:54
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums==null || nums.length<3) return ret;
        Arrays.sort(nums);
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0)break;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    ret.add(new ArrayList<>(tmpList));
                    tmpList.clear();
                    while(left<right&&nums[left+1]==nums[left])left++;
                    left++;
                }
            }
            while(i<nums.length-2 && nums[i+1]==nums[i])i++;
        }
        return ret;
    }
}
