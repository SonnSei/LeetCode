package g4.p429N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/23 22:05
 * @Author SonnSei
 */
public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            tmp.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                tmp.add(cur.val);
                for(Node node:cur.children)
                    queue.add(node);
            }
            ret.add(new ArrayList<>(tmp));

        }
        return ret;

    }
}
