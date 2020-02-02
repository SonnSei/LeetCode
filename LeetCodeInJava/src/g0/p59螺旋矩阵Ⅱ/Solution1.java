package g0.p59螺旋矩阵Ⅱ;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 14:16
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] nums = generateMatrix(3);

    }

    public static void printNums(int[][] nums) {
        for (int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n < 1) return null;
        int[][] ret = new int[n][n];
        int l = 0, r = n - 1, u = 0, d = n - 1;
        int end = n * n;
        int i = 1;
        while (i <= end) {
            for (int j = l; j <= r; j++) {
                ret[u][j] = i;
                i++;
            }

            for (int j = u + 1; j <= d; j++) {
                ret[j][r] = i;
                i++;
            }

            if (u != d) {
                for (int j = r - 1; j >= l; j--) {
                    ret[d][j] = i;
                    i++;
                }

            }
            if (l != r) {
                for (int j = d - 1; j > u; j--) {
                    ret[j][l] = i;
                    i++;
                }
            }

            l++;
            r--;
            u++;
            d--;
        }
        return ret;
    }
}
