package g2.p221最大正方形;

import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/28 11:13
 * @Author SonnSei
 */
public class Solution2 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] dp = new int[cols];
        int max = 0;
        int pre = 0;
        int tmp= 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp = dp[j];
                if (matrix[i][j] != '1') {
                    dp[j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    // 不可用放在这个地方，tmp的值是一定要修改的，需要放在条件判断外
                    // tmp = dp[j];
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre)+1;
                }
                // 要在dp[j]修改之前存起来，不要再修改之后再存
                pre = tmp;
                max = dp[j]>max?dp[j]:max;
            }
        }
        return max*max;
    }
}
