package 树.p94二叉树中序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/19 21:46
 * @Author SonnSei
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ret.add(node.val);
            node = node.right;
        }
        return ret;
    }

    public List<Integer> inorderMorris(final TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                // ---wrong--->while (pre != null && pre != cur) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    ret.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ret;
    }
}
