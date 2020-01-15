package p62不同路径;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/15 18:16
 * @Author SonnSei
 */
public class Solution2 {

    int[][] board;
    int cnt;

    public int uniquePaths(int m, int n) {
        if(m==1||n==1)return 1;
        board = new int[m][n];
        cnt = 0;
        backTrace(0, 0);
        return cnt;
    }

    private void backTrace(int x, int y) {
        if (x == board.length - 1 && y == board[0].length - 1) {
            cnt++;
            return;
        }
        if (inArea(x + 1, y)) {
            backTrace(x+1,y);
        }
        if (inArea(x, y + 1)) {
            backTrace(x, y + 1);
        }
    }

    private boolean inArea(int x, int y) {
        if (x < 0 || x > board.length - 1) return false;
        if (y < 0 || y > board[0].length-1) return false;
        return true;
    }
}
