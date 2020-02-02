package g1;

import util.TreeNode;

/**
 * @Classname Solution110
 * @Description 平衡二叉树
 * @Date 2019/12/19 17:43
 * @Author SunCheng
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1?(isBalanced(root.left)&&isBalanced(root.right)):false;
    }

    private int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
