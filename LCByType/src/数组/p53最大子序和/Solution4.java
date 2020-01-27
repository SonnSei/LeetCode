package 数组.p53最大子序和;

/**
 * @Classname Solution4
 * @Description
 * @Date 2020/1/27 9:23
 * @Author SonnSei
 */
public class Solution4 {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private static int maxSubArray(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
//            if(nums[l]>0)
//                return nums[l];
//            else
//                return 0;//子序列可以选空串
        }

        int mid = (l+r)>>>1;
        int maxLeftSum = maxSubArray(nums, l, mid);
        int maxRightSum = maxSubArray(nums, mid + 1, r);

        //这个地方，要根据情况判断是否可以为0。如果字串可以为空，那就可以为0
        int maxLeftBorderSum = nums[mid],maxRightBorderSum=nums[mid+1];
        int temp = 0;
        for (int i = mid; i >=l ; i--) {
            temp+=nums[i];
            maxLeftBorderSum = Math.max(temp, maxLeftBorderSum);
        }
        temp = 0;
        for (int i = mid+1; i <=r ; i++) {
            temp+=nums[i];
            maxRightBorderSum = Math.max(temp, maxRightBorderSum);
        }
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }
}
