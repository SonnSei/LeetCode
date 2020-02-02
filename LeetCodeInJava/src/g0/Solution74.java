package g0;

import java.util.Arrays;

/**
 * @Classname Solution74
 * @Description 搜索二维矩阵
 * @Date 2019/12/17 15:09
 * @Created by SunCheng
 */
public class Solution74 {
    public boolean Find(int target, int[][] matrix) {
        boolean ret = false;
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return ret;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            col = Arrays.binarySearch(matrix[row], 0, col + 1, target);
            if (col >= 0) {
                ret = true;
                break;
            }
            col = -col - 1;
            if (col == 0) break;
            col--;
            row = bSearch(matrix, col, row, target);
            if (row >= 0) {
                ret = true;
                break;
            }
            row = -row - 1;
            if (row == matrix.length) break;
        }
        return ret;
    }

    private int bSearch(int[][] matrix, int col, int fromIndex, int target) {
        int low = fromIndex;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = matrix[mid][col];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public boolean Find2(int target, int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = 0, col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            int cur = matrix[row][col];
            if (target < cur) {
                col--;
            } else if (target > cur) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
