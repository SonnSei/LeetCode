package g0.p73矩阵置零;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/16 7:55
 * @Author SonnSei
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean row1Flag = false, col1Flag = false;
        for (int val : matrix[0])
            if (val == 0) row1Flag = true;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col1Flag = true;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(row1Flag)Arrays.fill(matrix[0],0);
        if (col1Flag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0]=0;
            }
        }

    }
}
