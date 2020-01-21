package 树.p111二叉树的最小深度;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 20:29
 * @Author SonnSei
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
