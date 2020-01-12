package p16最接近的三数之和;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/12 9:11
 * @Author SonnSei
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i <nums.length-2 ; i++) {
            // 本想下面这句做优化，但是逻辑上有错误比如
            // [1,2,4,8,16,32,64,128] 82
            // 其中1+16+64==81，此时min==1，然后当nums[i]=2时，跳出了循环
            // 但是最终结果是2+16+64==82，所以就出错了
            // if(nums[i]>=min)break;
            int left = i+1,right = nums.length-1;
            while (left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)return target;
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ret = sum;
                }
                if(sum<target)
                    left++;
                if(sum>target)
                    right--;
            }
        }
        return ret;
    }
}
