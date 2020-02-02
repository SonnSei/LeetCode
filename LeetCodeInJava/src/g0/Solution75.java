package g0;

/**
 * @Classname Solution75
 * @Description TODO
 * @Date 2020/1/5 6:41
 * @Author SonnSei
 */
public class Solution75 {

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)return;
        // 初始化左右边界
        int left = 0;
        int right = nums.length-1;
        while(left<nums.length && nums[left]==0)left++;
        while(right >=0 && nums[right]==2)right--;
        int cur = left;
        while (cur <= right) {
            if(nums[cur]==0)
                swap(nums,left++,cur++);
            else if(nums[cur]==2)
                swap(nums, cur, right--);
            else
                cur++;
        }
    }
    public static void swap(int[] nums,int a,int b){
        if(a == b)return;
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
