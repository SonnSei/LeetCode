package p62不同路径;

import java.util.Arrays;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/1/15 18:24
 * @Author SonnSei
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i==0||j==0)
//                    dp[i][j]=1;
//            }
//        }
//        for (int i = 1; i <m ; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                System.out.println(Arrays.toString(dp));
                dp[j] += dp[j - 1];
            }
        }
        return dp[n-1];
    }
}
