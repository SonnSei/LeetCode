package g10;

/**
 * @Classname Solution1025
 * @Description 除数博弈
 * @Date 2019/12/20 10:04
 * @Author SunCheng
 */
public class Solution1025 {
    /**
     * 动态规划
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        if(N==1)return false;
        if(N == 2)return true;
        int[] dp = new int[N + 1];
        dp[2] = 1;
        for (int i = 3; i <=N ; i++) {
            for (int j = 1; j <i ; j++) {
                if (i % j == 0 && dp[i - j] == 0) {
                    dp[i]=1;
                }
            }
        }
        return dp[N]==1;
    }

    public boolean divisorGame2(int N) {
        return (N&1)==0;
    }
}
