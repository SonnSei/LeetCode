package 树.p337打家劫舍Ⅲ;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 19:00
 * @Author SonnSei
 */
public class Solution1 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ret = dfs(root, true);
        return Math.max(ret[0],ret[1]);
    }

    // [选当前节点，不选当前节点]
    private int[] dfs(TreeNode node, boolean canRobThis) {
        if (node == null) return new int[]{0,0};
        if (!canRobThis) {
            int[] left = dfs(node.left, true);
            int[] right = dfs(node.right, true);
            return new int[]{left[0]+right[0],left[1]+right[1]};
        } else {
            int[] left = dfs(node.left, true);
            int[] right = dfs(node.right, true);
            int[] ret = new int[]{left[1] + right[1], Math.max(left[1] + right[1],left[0] + right[0] + node.val)};
            return ret;
        }
    }
}
