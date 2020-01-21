package 树.p114二叉树展开为链表;

import util.TreeNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 20:49
 * @Author SonnSei
 */
public class Solution {
    TreeNode pre;
    public void flatten(TreeNode root) {
        order(root);
    }

    private void order(TreeNode node) {
        if(node == null)return;
        order(node.right);
        order(node.left);
        node.left = null;
        node.right = pre;
        pre = node;
    }
}
