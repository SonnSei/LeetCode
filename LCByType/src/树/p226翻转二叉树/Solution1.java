package 树.p226翻转二叉树;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 21:05
 * @Author SonnSei
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        TreeNode tmp = root.left;
        root.left =root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
