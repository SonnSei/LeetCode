package g2.p215数组中的第K大元素;

/**
 * @Classname Solution2
 * @Description 利用快排
 * @Date 2020/2/13 11:32
 * @Author SonnSei
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0)return 0;
        int n = nums.length;
        if(k<1||k>n)return 0;
        return getKth(nums, n - k + 1,0,n-1 );
    }
    private int getKth(int[] nums, int k, int left, int right) {
        int index = partition(nums, left, right);
        if(index+1 == k)return nums[index];
        else if(index+1>k) return getKth(nums, k, left, index - 1);
        else return getKth(nums, k, index + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int l = left,r = right;
        int pivot = nums[l];
        while(l<r){
            while(l<r && nums[r]>=pivot)r--;
            while(l<r && nums[l]<=pivot)l++;
            swap(nums,l,r);
        }
        swap(nums,l,left);
        return l;
    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
