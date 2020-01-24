package 数组.p35搜索插入位置;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/24 19:58
 * @Author SonnSei
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid])
                right = mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                return mid;
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (target > nums[mid])
                left = mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                return mid;
        }

        // 从left跳right和从right跳left两种导致跳出的方式分析一下，
        // 就可以得出插入位置是left+1
        return left+1;

    }

    public int searchInsert3(int[] nums, int target) {
        int left=-1,right = nums.length;
        while (left < right - 1) {
            int mid =(left+right)>>>1;
            if(target<nums[mid])
                right=mid;
            else if(target>nums[mid])
                left=mid;
            else
                return mid;
        }
        return left+1;
    }
}
