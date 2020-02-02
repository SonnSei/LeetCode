package g1.p104二叉树的最大深度;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 19:41
 * @Author SonnSei
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
