package g0;

/**
 * @Classname Solution53
 * @Description TODO
 * @Date 2019/12/7 17:36
 * @Created by Jesse
 */
public class Solution53 {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法，O(n^3)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = 0;
                for (int k = j; k <= i; k++) {
                    temp += nums[k];
                }
                max = max > temp ? max : temp;
            }
        }
        return max;
    }

    /**
     * 动态规划，利用和数组，快速求解区间范围和，O（n^2）
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            for (int j = 0; j <= i; j++) {
                int temp = sums[i+1]-sums[j];
                if(temp>max)
                    max = temp;
            }
        }
        return max;
    }

    /**
     * 第二种解法的改进，不需要数组记录临时和，只需要维护一个int变量就行了，复杂度不变，空间复杂度变为O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            //注意这个地方改了
            for (int j = i; j <nums.length; j++) {
                temp+=nums[j];
                if(temp>max)
                    max = temp;
            }
        }
        return max;
    }

    /**
     * 诡异的分治算法，O（nlogn）
     * 有些地方需要根据返回值是否可以为空来做出调整
     *
     * @param nums
     * @return
     */
    public static int maxSubArray4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray4(nums, 0, nums.length - 1);
    }

    private static int maxSubArray4(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
//            if(nums[l]>0)
//                return nums[l];
//            else
//                return 0;//子序列可以选空串
        }

        int mid = (l+r)>>>1;
        int maxLeftSum = maxSubArray4(nums, l, mid);
        int maxRightSum = maxSubArray4(nums, mid + 1, r);

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


    /**
     * 线性的复杂度 O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray5(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = max>sum?max:sum;
        }
        return max;
    }
}

