package 树.p96不同的二叉搜索树;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/19 22:20
 * @Author SonnSei
 */
public class Solution1 {
    public int numTrees(int n) {
        if(n<2)return 1;
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }


    /**
     * 卡特兰数
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        if(n<2)return 1;
        long ret = 1;
        int i = 0;
        while (i < n) {
            ret = 2 * (2 * i + 1) * ret / (i + 2);
            i++;
        }
        return (int) ret;
    }
}

