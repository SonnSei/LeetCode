package g0.p37解数独;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/13 18:56
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        new Solution2().solveSudoku(board);
        solveSudoku(board);
        for (char[] row : board)
            System.out.println(Arrays.toString(row));

    }

    static int[][] rowArray = new int[9][10];
    static int[][] colArray = new int[9][10];
    static int[][] boxArray = new int[9][10];

    static boolean finish = false;

    public static void solveSudoku(char[][] board) {
        // 每次重新初始化一下，因为测试的时候可能用的是同一个类实例
        rowArray = new int[9][10];
        colArray = new int[9][10];
        boxArray = new int[9][10];
        finish = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int digit = Character.getNumericValue(c);
                addNum(digit,i,j,board);
            }
        }
        backTrack(board, 0, 0);
    }

    private static void backTrack(char[][] board, int row, int col) {
        char c = board[row][col];
        if (c != '.') {
            checkNext(row, col,board);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (canPlace(row, col, i)) {
                    addNum(i, row, col,board);
                    checkNext(row, col,board);
                    if (!finish) removeNum(i, row, col,board);
                }
            }
        }
    }

    private static void addNum(int i, int row, int col,char[][] board) {
        int boxIndex = (row / 3) * 3 + col / 3;
        rowArray[row][i]++;
        colArray[col][i]++;
        boxArray[boxIndex][i]++;
        board[row][col] = (char) (i + '0');
    }

    private static void removeNum(int i, int row, int col, char[][] board) {
        int boxIndex = (row / 3) * 3 + col / 3;
        rowArray[row][i]--;
        colArray[col][i]--;
        boxArray[boxIndex][i]--;
        board[row][col] = '.';
    }

    private static void checkNext(int row, int col,char[][] board) {
        if (row == 8 && col == 8) {
            finish = true;
            return;
        }
        if (col < 8) {
            backTrack(board, row, col + 1);
        } else {
            backTrack(board, row + 1, 0);
        }
    }

    private static boolean canPlace(int row, int col, int value) {
        int boxIndex = (row / 3) * 3 + col / 3;
        if (rowArray[row][value] > 0 || colArray[col][value] > 0 || boxArray[boxIndex][value] > 0) return false;
        return true;
    }
}
