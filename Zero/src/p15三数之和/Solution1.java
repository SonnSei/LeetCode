package p15三数之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/12 8:55
 * @Author SonnSei
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums == null || nums.length<3)return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            // 题目是求和为0，所以当最小值大于0的时候就可以结束了
            if(nums[i]>0)break;
            // 去重
            if(i>0 && nums[i]==nums[i-1])continue;
            int left =i+1,right = nums.length-1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    List<Integer> item = Arrays.asList(nums[i], nums[left], nums[right]);
                    ret.add(item);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;right--;
                }else if(sum < -nums[i])
                    left++;
                else
                    right--;
            }
        }
        return ret;
    }
}
