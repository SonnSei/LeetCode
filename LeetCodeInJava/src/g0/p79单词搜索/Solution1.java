package g0.p79单词搜索;

/**
 * @Classname Solutiojn1
 * @Description
 * @Date 2020/1/17 8:10
 * @Author SonnSei
 */
public class Solution1 {
    static boolean ret;
    public boolean exist(char[][] board, String word) {
        ret  = false;
        if(board==null || board.length==0 || board[0].length==0)return ret;
        if(word==null || word.length()==0)return false;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] used = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                used[i][j] = true;
                dfs(board,used, i, j, 0, word);
                used[i][j] = false;
            }
        }
        return ret;
    }

    private void dfs(char[][] board,boolean[][] used, int x, int y, int index, String word) {
        if(ret)return;
        if(board[x][y]!=word.charAt(index))return;
        // 这个地方为什么不是判断index == word.length()？ 因为下面的inArea拦着，index永远不会==word.length
        if (index == word.length()-1 && (ret = true)) return;
        for (int[] move : moves) {
            int x2 = x + move[0];
            int y2 = y+move[1];
            if (inArea(board.length, board[0].length, x2, y2) && !used[x2][y2]) {
                used[x2][y2] = true;
                dfs(board,used, x2, y2, index + 1, word);
                used[x2][y2] = false;
            }
        }
    }

    static int[][] moves = {
            {1,0},{-1,0},{0,1},{0,-1}
    };

    private boolean inArea(int rows, int cols, int x, int y) {
        if(x<0 || x>=rows)return false;
        if(y<0 || y>=cols)return false;
        return true;
    }
}
