package One;

import util.TreeNode;

/**
 * @Classname Solution114
 * @Description 二叉树展开为链表
 * @Date 2019/12/19 19:22
 * @Author SunCheng
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        if(root == null)return;
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        if(node==null) return ;
        if (node.left != null) {
            TreeNode right = node.right;
            node.right = node.left;
            node.right.right = right;
            preOrder(right);
        }
        if (node.right != null) {
            TreeNode right = preOrder(node.right);
            node.right = right;
            node = node.right;
        }
        return root;
    }
}
