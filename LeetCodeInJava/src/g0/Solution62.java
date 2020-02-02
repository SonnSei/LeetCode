package g0;

/**
 * @Classname Solution62
 * @Description 不同路径
 * @Date 2019/12/24 9:48
 * @Author Cheng
 */
public class Solution62 {
    public static void main(String[] args) {
        int ret = uniquePaths2(7, 3);
        System.out.println(ret);
//        int ret = 1;
//        for (int i = 1; i <5 ; i++) {
////            ret*=i;
//            ret = ret*i;
//            System.out.println(ret);
//        }
    }

    public int uniquePaths(int m, int n) {
        if(m<1 || n<1)return 0;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        dp[1][0] = 1;
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i&1][j] = dp[(i - 1)&1][j] + dp[i&1][j - 1];
            }
        }
        return dp[(m - 1)&1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {

        int N = n + m - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res*(N - k + i) / i;
        // 下面这样写就不行，而且*= 就和下面这种写法一样
//            res = res * ((N - k + i) / i);
        return (int) res;

    }


}
