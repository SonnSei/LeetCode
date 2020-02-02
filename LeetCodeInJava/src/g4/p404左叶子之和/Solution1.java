package g4.p404左叶子之和;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 20:50
 * @Author SonnSei
 */
public class Solution1 {
    int ret;

    public int sumOfLeftLeaves(TreeNode root) {
        ret = 0;
        if (root == null) return ret;
        preOrder(root);
        return ret;
    }

    private void preOrder(TreeNode node) {
        if (node == null) return;
        if (node.left != null && isLeaf(node.left)) ret += node.left.val;
        preOrder(node.left);
        preOrder(node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
