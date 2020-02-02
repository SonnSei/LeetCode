package g4;

/**
 * @Classname Solution493
 * @Description TODO
 * @Date 2019/12/22 10:02
 * @Author SunCheng
 */
public class Solution493 {
    static int cnt;
    public static int reversePairs(int[] nums) {
        cnt = 0;
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l+(r-l)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);

            int left = l, right = mid + 1;
            while(right <= r){
                while(left <= mid && nums[left]/2.0<=nums[right])
                    left++;
                cnt += mid - left + 1;
                right++;
            }

            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int p = 0;
        int i = l,j = mid+1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[p++] = nums[i++];
            } else {
                temp[p++] = nums[j++];
            }
        }

        while (i <= mid)temp[p++] = nums[i++];
        while(j<=r)temp[p++] = nums[j++];

        for (int k = 0; k < temp.length; k++) {
            nums[k+l] = temp[k];
        }
    }
}
