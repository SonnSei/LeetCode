package 树.p226翻转二叉树;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/22 21:10
 * @Author SonnSei
 */
public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.right!=null) queue.add(node.right);
            if(node.left!=null) queue.add(node.left);
        }
        return root;
    }
}
