package g2.p221最大正方形;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/2/28 10:38
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {

    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0||matrix[0].length==0)return 0;
        int rows = matrix.length,cols = matrix[0].length;
        int[][] dp = new int[2][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]!='1'){
                    dp[i&1][j]=0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i&1][j] = 1;
                } else {
                    dp[i&1][j] = Math.min(Math.min(dp[(i-1)&1][j],dp[i&1][j-1]),dp[(i-1)&1][j-1])+1;
                }
                max = Math.max(max, dp[i &1][j]);
                System.out.println(Arrays.toString(dp[i&1]));
            }
        }
        return max*max;
    }
}
