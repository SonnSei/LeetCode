package 树.p101对称二叉树;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 18:11
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val!=node2.val) return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
