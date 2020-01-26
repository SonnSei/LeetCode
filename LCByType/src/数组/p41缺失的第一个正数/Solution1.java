package 数组.p41缺失的第一个正数;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/26 14:06
 * @Author SonnSei
 */
public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)return 1;
        boolean noOne = true;
        for (int val : nums) {
            if (val == 1) {
                noOne =false;
                break;
            }
        }
        if(noOne)return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i]=1;
            }
        }

        for (int val : nums) {
            int index = Math.abs(val);
            if (index == nums.length) {
                nums[0] = nums[0] > 0 ? -nums[0] : nums[0];
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for (int i = 2; i <nums.length ; i++) {
            if(nums[i]>0)return i;
        }

        if(nums[0]>0)return nums.length;
        return nums.length+1;
    }
}
