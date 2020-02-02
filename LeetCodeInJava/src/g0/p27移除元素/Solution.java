package g0.p27移除元素;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 18:22
 * @Author SonnSei
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)return 0;
        int left=0,right=0;
        while (right < nums.length) {
            if(nums[right]==val)right++;
            else swap(nums,left++,right++);
        }
        return left;
    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
