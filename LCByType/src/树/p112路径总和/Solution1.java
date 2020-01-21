package 树.p112路径总和;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 20:32
 * @Author SonnSei
 */
public class Solution1 {
    boolean ret;
    public boolean hasPathSum(TreeNode root, int sum) {
        ret = false;
        dfs(root, 0, sum);
        return ret;
    }

    private void dfs(TreeNode node, int tmpSum, int sum) {
        if(ret||node == null)return;
        tmpSum+=node.val;
        if (node.left == null && node.right == null && tmpSum == sum) {
            ret = true;
            return;
        }
        dfs(node.left,tmpSum,sum);
        dfs(node.right, tmpSum, sum);
    }

}
