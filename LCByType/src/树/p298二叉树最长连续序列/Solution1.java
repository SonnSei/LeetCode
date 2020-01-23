package 树.p298二叉树最长连续序列;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 18:12
 * @Author SonnSei
 */
public class Solution1 {
    static int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        if(root == null)return max;
        recursive(root);
        return max;
    }

    private int recursive(TreeNode node) {
        if(node == null)return 0;
        int left = recursive(node.left);
        int right = recursive(node.right);
        int curValue = 1;
        if (left > 0 && node.val + 1 == node.left.val) {
            curValue = Math.max(curValue,left+1);
        }
        if (right > 0 && node.val + 1 == node.right.val) {
            curValue = Math.max(curValue, right + 1);
        }
        max = Math.max(curValue, max);
        return curValue;
    }
}
