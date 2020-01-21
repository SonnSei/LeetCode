package 树.p103二叉树的锯齿形层次遍历;

import util.TreeNode;

import java.util.*;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 18:58
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            tmp.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(reverse)
                Collections.reverse(tmp);
            ret.add(new ArrayList<>(tmp));
            reverse = !reverse;
        }
        return ret;
    }
}
