package g0;

/**
 * @Classname Solution41
 * @Description TODO
 * @Date 2020/1/5 19:34
 * @Author SonnSei
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 答案只会出现在1到n+1之间
        // 先检查数组中是1的个数
        int oneCnt = 0;
        for (int val : nums) {
            if(val==1)oneCnt++;
        }

        if(oneCnt==0)return 1;
        if(n == 1)return 2;

        // 把小于等于0或者大于n的元素替换成1；
        for (int i = 0; i < n; i++) {
            if(nums[i]<=0||nums[i]>n)
                nums[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for (int i = 2; i <n ; i++) {
            if(nums[i]>0)return i;
        }
        if(nums[0]>0)return n;
        return n+1;
    }

}
