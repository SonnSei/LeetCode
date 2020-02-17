package 周赛.day20200216;

/**
 * @Classname Prblem1
 * @Description
 * @Date 2020/2/16 10:18
 * @Author SonnSei
 */
public class Problem1 {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}
        };
        System.out.println(countNegatives(grid));
    }

    /**
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     *
     * 请你统计并返回 grid 中 负数 的数目。
     * @param grid
     * @return
     */
    public static int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int col = n;
        for (int i = 0; i < m; i++) {
            while (col > 0 && grid[i][col - 1] < 0) col--;
            cnt += n - col;
        }
        return cnt;
    }
}

