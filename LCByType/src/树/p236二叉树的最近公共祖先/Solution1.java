package 树.p236二叉树的最近公共祖先;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 21:51
 * @Author SonnSei
 */
public class Solution1 {
    TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ret = null;
        getLAC(root, p, q);
        return ret;
    }

    private void getLAC(TreeNode node, TreeNode p, TreeNode q) {
        if(ret!=null)return;
        if(node == null)return;
        int l=0,m=0,r=0;
        if (node.val == p.val || node.val == q.val) {
            m = 1;
        }
        if (inPartial(node.left, p, q)) {
            l = 1;
        }
        if (inPartial(node.right, p, q)) {
            r = 1;
        }
        if (l + m + r > 1) {
            ret = node;
        }
        if (ret == null) {
            getLAC(node.left, p, q);
            getLAC(node.right, p, q);
        }
    }

    private boolean inPartial(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return false;
        if (root.val == p.val || root.val == q.val) {
            return true;
        }
        return inPartial(root.left, p, q) || inPartial(root.right, p, q);
    }
}
