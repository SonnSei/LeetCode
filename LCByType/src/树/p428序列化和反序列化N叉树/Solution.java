package 树.p428序列化和反序列化N叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/23 21:16
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        String data = "1#3!3#2!2#0!4#0!5#0!6#0!";
        Codec codec = new Codec();
        Node node = codec.deserialize(data);
        System.out.println(codec.serialize(node));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "#";
            StringBuilder ret = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int cnt = 0;
                if(node.children!=null)
                for (Node child : node.children) {
                    cnt++;
                    queue.add(child);
                }
                ret.append(node.val + "#"+cnt+"!");
            }
            return ret.toString();
        }

        class Pair{
            Node node;
            int cnt;

            public Pair(Node node, int cnt) {
                this.node = node;
                this.cnt = cnt;
            }
        }
        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            String[] values = data.split("!");
            if (values[0].equals("#")) return null;
            String[] rootV = values[0].split("#");
            Node root = new Node(Integer.parseInt(rootV[0]));
            int cnt = Integer.parseInt(rootV[1]);

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, cnt));
            int index = 1;

            while(index<values.length){
                Pair pair = queue.poll();
                System.out.println(pair.node.val+"  "+pair.cnt);
                pair.node.children = new ArrayList<>();
                for (int j = 0; j < pair.cnt; j++) {
                    String[] strs = values[index].split("#");
                    Node node = new Node(Integer.parseInt(strs[0]));
                    int cnt2 = Integer.parseInt(strs[1]);
                    pair.node.children.add(node);
                    queue.add(new Pair(node, cnt2));
                    index++;
                }
            }
            return root;
        }
    }
}
