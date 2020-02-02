package g0.p54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/27 10:02
 * @Author SonnSei
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length < 1) return ret;
        int rowUp = 0, rowDown = matrix.length - 1, colLeft = 0, colRight = matrix[0].length - 1;

        while (rowUp <= rowDown && colLeft <= colRight) {
            for (int col = colLeft; col <= colRight; col++) {
                ret.add(matrix[rowUp][col]);
            }
            for (int row = rowUp + 1; row <= rowDown; row++) {
                ret.add(matrix[row][colRight]);
            }
            if (rowDown != rowUp) {
                for (int col = colRight - 1; col >= colLeft; col--) {
                    ret.add(matrix[rowDown][col]);
                }
            }
            if (colLeft != colRight) {
                for (int row = rowDown - 1; row > rowUp; row--) {
                    ret.add(matrix[row][colLeft]);
                }
            }
            rowUp++;
            rowDown--;
            colLeft++;
            colRight--;
        }
        return ret;
    }
}
