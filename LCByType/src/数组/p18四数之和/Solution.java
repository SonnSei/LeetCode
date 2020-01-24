package 数组.p18四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 17:39
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums==null||nums.length<4)return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int cur = nums[i];
            List<List<Integer>> lists = threeSum(nums, target - cur, i + 1);
            for (List list : lists) {
                list.add(cur);
                ret.add(new ArrayList<>(list));
            }
            while(i<nums.length-3 && nums[i+1]==nums[i])i++;
        }
        return ret;
    }

    public List<List<Integer>> threeSum(int[] nums,int t,int start) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            int target = t-nums[i];
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
