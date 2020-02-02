package g1.p124二叉树中的最大路径和;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 21:45
 * @Author SonnSei
 */
public class Solution1 {
    static Integer max = null;
    public static int maxPathSum(TreeNode root) {
        // 按照题意，必须非空
//        if(root == null)
        getMaxPathSum(root);
        return max;
    }

    private static int getMaxPathSum(TreeNode node) {
        if (node.left == null && node.right == null) {
            if(max == null)
                max = node.val;
            max = Math.max(node.val, max);
            return node.val;
        }
        int leftResult = node.left==null?0:getMaxPathSum(node.left);
        int rightResult = node.right==null?0:getMaxPathSum(node.right);
        int plus = Math.max(Math.max(leftResult,rightResult),0);
        // 判断以该节点为根节点时左右子树中路径和是否为最大值
        max = Math.max(max, node.val + leftResult + rightResult);
        int ret = node.val+plus;
        max = Math.max(max, ret);
        return ret;
    }

}
