package p52N皇后Ⅱ;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/14 10:28
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solutino1 = new Solution1();
        System.out.println(solutino1.totalNQueens(2));
    }


    boolean[] rowArray;
    boolean[] colArray;
    boolean[][] board;
    int n;
    int cnt;

    public int totalNQueens(int n) {
        this.n = n;
        cnt = 0;
        if (n < 1) return cnt;
        board = new boolean[n][n];
        rowArray = new boolean[n];
        colArray = new boolean[n];
        backTrack(0);
        return cnt;
    }


    private void backTrack(int x) {
        if (x >= n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(x, i)) {
                rowArray[x] = true;
                colArray[i] = true;
                board[x][i] = true;
                backTrack(x + 1);
                board[x][i] = false;
                rowArray[x] = false;
                colArray[i] = false;
            }
        }
    }

    private boolean check(int a, int b) {
        int x = a, y = b;
        if (rowArray[x]) return false;
        if (colArray[y]) return false;
        while (x >= 0 && y >= 0) {
            if (board[x][y]) return false;
            x--;
            y--;
        }
        x = a;
        y = b;
        while (x < n && y < n) {
            if (board[x][y]) return false;
            x++;
            y++;
        }

        x = a;
        y = b;
        while (x >= 0 && y < n) {
            if (board[x][y]) return false;
            x--;
            y++;
        }

        x = a;
        y = b;
        while (x < n && y >= 0) {
            if (board[x][y]) return false;
            x++;
            y--;
        }
        return true;
    }
}
