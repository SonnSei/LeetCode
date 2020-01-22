package 树.p156上下翻转二叉树;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 10:56
 * @Author SonnSei
 */
public class Solution1 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return root;
        TreeNode node = root;
        TreeNode ret = null;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (ret == null) {
                ret = cur;
            }
            if (!stack.isEmpty()) {
                cur.left = stack.peek().right;
                cur.right = stack.peek();
            } else {
                // 注意这里，没有的话会导致死循环
                cur.left = null;
                cur.right = null;
            }
        }
        return ret;
    }
}
