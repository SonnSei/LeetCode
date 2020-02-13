package g3.p313超级丑数;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/13 17:23
 * @Author SonnSei
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<1)return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] next = new int[primes.length];
        for (int i = 1; i <n ; i++) {
            int nextItem = dp[next[0]] * primes[0];
            for (int j = 1; j <next.length ; j++) {
                int tmp = dp[next[j]] * primes[j];
                if (tmp < nextItem) {
                    nextItem = tmp;
                }
            }
            for (int j = 0; j < next.length; j++) {
                if(dp[next[j]] * primes[j]==nextItem){
                    next[j]++;
                }
            }
            dp[i]=nextItem;
        }
        return dp[n - 1];
    }
}
