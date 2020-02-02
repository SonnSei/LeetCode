package g1.p129求根节点到叶子节点的数字之和;

import util.TreeNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 22:51
 * @Author SonnSei
 */
public class Solution {
    int ret;
    public int sumNumbers(TreeNode root) {
        ret = 0;
        if(root == null)return ret;
        dfs(root,0);
        return ret;
    }

    private void dfs(TreeNode node, int sum) {
        sum*=10;
        sum+=node.val;
        if (node.left == null && node.right == null) {
            ret+=sum;
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum);
        }
        if (node.right != null) {
            dfs(node.right, sum);
        }
    }
}
