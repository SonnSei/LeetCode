package g2;

/**
 * @Classname Solution264
 * @Description TODO
 * @Date 2019/12/22 9:48
 * @Author SunCheng
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        if (n < 7) return n;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            int next = Math.min(Math.min(next2, next3), next5);
            if (next == next2)
                i2++;
            if (next == next3)
                i3++;
            if (next == next5)
                i5++;

            dp[i] = next;
        }
        return dp[n - 1];
    }
}
