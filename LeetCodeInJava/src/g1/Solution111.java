package g1;

import util.TreeNode;

/**
 * @Classname Solution111
 * @Description 二叉树的最小深度
 * @Date 2019/12/19 17:51
 * @Author SunCheng
 */
public class Solution111 {
    /**
     * 关于二叉树的问题，很多是根据节点的状态来分情况的，而节点就这么几种状态
     * 1. null
     * 2. left!=null && right!=null
     * 3. left == null && right!=null
     * 4. right != null && right == null
     * 5. left == null && right == null
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
