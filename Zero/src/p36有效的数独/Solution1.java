package p36有效的数独;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/13 18:25
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowArray = new int[9][10];
        int[][] colArray = new int[9][10];
        int[][] boxArray = new int[9][10];
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c=='.')continue;
                int digit = c-'0';
                rowArray[i][digit]++;
                colArray[j][digit]++;
                int boxIndex = (i/3)*3+j/3;
                boxArray[boxIndex][digit]++;
                if(rowArray[i][digit]>1||colArray[j][digit]>1|boxArray[boxIndex][digit]>1)return false;
            }
        }
        return true;
    }
}
