package p80删除排序数组中的重复项Ⅱ;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/17 8:29
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums==null)return 0;
        int n;
        if((n=nums.length)<2)return nums.length;
        int left = 0,right=0;
        while (right < n) {
            while (right < n - 1 && nums[right] != nums[right + 1]) {
                swap(nums,left++,right++);
            }
            int cur = nums[right];
            if (right == n - 1) {
                swap(nums,left++,right++);
                break;
            }
            swap(nums,left++,right++);
            swap(nums,left++,right++);
            while(right<n && nums[right]==cur)right++;
        }
        return left;
    }
    public static void swap(int[] nums,int a,int b){
        if(a==b)return;
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
