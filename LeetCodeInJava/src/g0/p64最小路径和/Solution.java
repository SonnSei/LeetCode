package g0.p64最小路径和;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/17 10:09
 * @Author SonnSei
 */
public class Solution {
    int min;
    public int minPathSum(int[][] grid) {
        min = 0;
        if(grid==null || grid.length==0||grid[0].length==0)return 0;
        dfs(grid,0,0,0);
        return min;
    }

    private void dfs(int[][] grid, int x, int y, int sum) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            sum+=grid[x][y];
            if(min==0 || sum<min)min = sum;
            return;
        }

        sum += grid[x][y];
        if (x + 1 < grid.length) {
            dfs(grid, x + 1, y, sum);
        }
        if (y + 1 < grid[0].length) {
            dfs(grid, x, y + 1, sum);
        }
    }
}
