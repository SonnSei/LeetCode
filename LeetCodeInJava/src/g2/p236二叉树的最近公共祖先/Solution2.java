package g2.p236二叉树的最近公共祖先;

import util.TreeNode;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/22 21:53
 * @Author SonnSei
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = new TreeNode(0);
        recurseTree(root, p, q,ret);
        return ret;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q, TreeNode ret) {
        if(root==null)return false;
        int left = recurseTree(root.left,p,q,ret)?1:0;
        int right = recurseTree(root.right,p,q,ret) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val)?1:0;

        if(left+mid+right>=2)ret.val = root.val;
        return (left+mid+right)>0;
    }
}
