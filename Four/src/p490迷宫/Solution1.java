package p490迷宫;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 1:11
 * @Author SonnSei
 */
public class Solution1 {

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean ret;

    /**
     * 注意注释，一开始为什么会超时
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        ret = false;
//        if(start[0]==destination[0] && start[1]==destination[1])return true;
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        dfs(maze, visited, start[0], start[1], destination);
        return ret;
    }

    private void dfs(int[][] maze, boolean[][] visited, int x, int y, int[] destination) {
        if (visited[x][y] || ret) return;
        visited[x][y] = true;
        for (int[] move : moves) {
            int x2 = x ;
            int y2 = y ;
            while (inArea(x2+ move[0], y2+ move[1], maze)) {
                if (x == destination[0] && y == destination[1]) {
                    ret = true;
                    return;
                }
                x2 = x2 + move[0];
                y2 = y2 + move[1];
            }
            dfs(maze, visited, x2, y2, destination);
        }
        // 注意这个地方不需要回溯
        //visited[x][y] = false;
    }

    private boolean inArea(int x, int y, int[][] maze) {
        if (x < 0 || x >= maze.length) return false;
        if (y < 0 || y >= maze[0].length) return false;
        if (maze[x][y] == 1) return false;
        return true;
    }

}
