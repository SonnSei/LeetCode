package g2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution211
 * @Description 添加与搜索单词 - 数据结构设计
 * @Date 2020/1/8 8:28
 * @Author SonnSei
 */
public class Solution211 {
    class WordDictionary {
        class Node{
            public boolean isWord;
            public Map<Character,Node> next;
            public Node(boolean isWord){
                this.isWord = isWord;
                next = new HashMap<>();
            }

            public Node(){
                this(false);
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(cur.next.get(c)==null)
                    cur.next.put(c,new Node());
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word);
        }



        public boolean search(Node node,String word) {
            Node cur = node;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (c == '.') {
                    String word2 = word.substring(i + 1);
                    boolean ret = false;
                    for (char key : cur.next.keySet()) {
                        ret |= search(cur.next.get(key),word2);
                    }
                    return ret;
                }
                if(cur.next.get(c)==null)return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }
    }
}
