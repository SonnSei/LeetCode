package g2;

import java.util.*;

/**
 * @Classname Solution212
 * @Description 单词搜索 II
 * @Date 2020/1/8 8:55
 * @Author SonnSei
 */
public class Solution212 {
    Trie trie;
    int rows;
    int cols;
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        rows  = board.length;
        cols = board[0].length;
        StringBuilder stringBuilder = new StringBuilder();
        boolean[][] visited = new boolean[rows][cols];
        Set<String> set = new HashSet<>();
        for (String word : words) {
           trie.add(word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j]=true;
                dfs(board, visited, i, j, stringBuilder,set);
                visited[i][j]=false;
            }
        }
        List<String> ret = new ArrayList<>();
        for (String item : set) {
            ret.add(item);
        }
        return ret;
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, StringBuilder sb,Set<String> set) {
        sb.append(board[x][y]);
        if (!trie.isPrefix(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (trie.contains(sb.toString())) {
            set.add(sb.toString());
        }
        for (int[] move : moves) {
            int x2 = x + move[0];
            int y2 = y + move[1];
            if (inArea(x2, y2) && !visited[x2][y2]) {
                visited[x2][y2]=true;
                dfs(board,visited,x2,y2,sb,set);
                visited[x2][y2]=false;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    static int[][] moves={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private boolean inArea(int x, int y) {
        if(x<0 || x>=rows)return false;
        if(y<0 || y>=cols)return false;
        return true;
    }



    class Trie {
        private class Node{
            public boolean isWord;
            public Map<Character,Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new HashMap<>();
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }


        public void add(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        public boolean contains(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c)==null)return  false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean isPrefix(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c= prefix.charAt(i);
                if(cur.next.get(c)==null)return false;
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
