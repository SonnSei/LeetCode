package p51N皇后;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/14 9:59
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<String>> lists = solution1.solveNQueens(2);
        for (List list : lists) {
            System.out.println(list);
        }
    }

    boolean[] rowArray;
    boolean[] colArray;
    boolean[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<String>> ret = new ArrayList<>();
        if(n<1)return ret;
        board = new boolean[n][n];
        rowArray = new boolean[n];
        colArray = new boolean[n];
        backTrack(0, ret);
        return ret;
    }

    private void backTrack(int x,  List<List<String>> ret) {
        if (x >= n) {
            ret.add(getBoardList());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(x, i)) {
                rowArray[x]= true;
                colArray[i] = true;
                board[x][i] = true;
                backTrack(x+1,ret);
                board[x][i] = false;
                rowArray[x]= false;
                colArray[i] = false;
            }
        }
    }

    private boolean check(int a, int b) {
        int x = a,y = b;
        if(rowArray[x])return false;
        if(colArray[y])return false;
        while (x >= 0 && y >= 0) {
            if(board[x][y])return false;
            x--;y--;
        }
        x = a;y = b;
        while (x <n && y <n) {
            if(board[x][y])return false;
            x++;y++;
        }

        x = a;y = b;
        while (x >=0 && y <n) {
            if(board[x][y])return false;
            x--;y++;
        }

        x = a;y = b;
        while (x <n && y >=0) {
            if(board[x][y])return false;
            x++;y--;
        }
        return true;
    }

    private List<String> getBoardList() {
        List<String> ret = new ArrayList<>();
        StringBuilder sb;
        for (boolean[] row : board) {
            sb = new StringBuilder();
            for(boolean val:row)
                sb.append(val ? 'Q' : '.');
            ret.add(sb.toString());
        }
        return ret;
    }
}
