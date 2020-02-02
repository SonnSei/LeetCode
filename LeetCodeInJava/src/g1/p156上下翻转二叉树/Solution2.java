package g1.p156上下翻转二叉树;

import util.TreeNode;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/22 11:17
 * @Author SonnSei
 */
public class Solution2 {
    TreeNode ret;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // 不要少了这个判断
        if(root==null)return root;
        ret = null;
        recursion(root);
        return ret;
    }

    private TreeNode recursion(TreeNode node) {
        if (node.left == null) {
            ret = node;
            return node;
        }
        TreeNode tmp = recursion(node.left);
        tmp.left = node.right;
        tmp.right = node;
        // 没有下面这两个会导致死循环
        node.left=null;
        node.right=null;
        return node;
    }
}
