package g0;

/**
 * @Classname Solution96
 * @Description 不同的二叉搜索树
 * @Date 2020/1/7 14:02
 * @Author SonnSei
 */
public class Solution96 {
    public static void main(String[] args) {
        for (int i = 0; i < 19; i++) {
            System.out.print(numTrees(i) + " ");
        }
    }


    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if(n<2)return 1;
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 递归+备忘录
     * @param n
     * @return
     */
    public static int numTrees2(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return recursion(n, dp);
    }

    private static int recursion(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
        int count = 0;
        for (int i = 0; i < n; i++)
            count += recursion(i - 0, dp) * recursion(n - i - 1, dp);
        dp[n] = count;
        return count;
    }

    /**
     * 卡特兰数
     * 1 1 2 5 14 42 132 429 1430 4862
     *
     * @param n
     * @return
     */
    public static int numTrees1(int n) {
        long ret = 1;
        for (int i = 0; i < n; i++) {
            ret = 2 * (2 * i + 1) * ret / (i + 2);
        }
        return (int) ret;
    }
}
