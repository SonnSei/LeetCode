package 树.p235二叉搜索树的最近公共祖先;

import util.TreeNode;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/22 21:47
 * @Author SonnSei
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
