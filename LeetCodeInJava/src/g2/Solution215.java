package g2;

/**
 * @Classname Solution215
 * @Description 数组中的第K个最大元素
 * @Date 2019/12/16 11:19
 * @Created by SunCheng
 */
public class Solution215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        int partition = partition(nums, 0, nums.length-1);
        int target = nums.length+1-k;
        while (partition+1 != target) {
            if (partition + 1 < target) {
                partition = partition(nums, partition + 1, nums.length - 1);
            } else {
                partition = partition(nums, 0, partition - 1);
            }
        }
        return nums[partition];
    }

    public static int partition(int[] nums, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = nums[left];
        // 先从右边走
        while (p1 < p2) {
            while (nums[p2] >= pivot && p1 < p2)
                p2--;
            while (nums[p1] <= pivot && p1 < p2)
                p1++;
            swap(nums, p1, p2);
        }
        swap(nums, left, p1);
        return p1;
    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
