package g1.p152乘积最大序列;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/18 10:27
 * @Author SonnSei
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int max = Integer.MIN_VALUE;
        int imax = 1,imin=1;
        for (int val : nums) {
            if(val<0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * val, val);
            imin = Math.min(imin * val, val);
            max = Math.max(max, imax);
        }
        return max;
    }
}
