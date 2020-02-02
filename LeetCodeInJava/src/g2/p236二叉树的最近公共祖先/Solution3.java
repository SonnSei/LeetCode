package g2.p236二叉树的最近公共祖先;

import util.TreeNode;

/**
 * @Classname Solution3
 * @Description 尝试改进效率
 * @Date 2020/1/22 21:56
 * @Author SonnSei
 */
public class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = new TreeNode(0);
        getLAC(root, p, q, ret);
        return ret;
    }

    private boolean getLAC(TreeNode root, TreeNode p, TreeNode q, TreeNode ret) {
        if(root == null) return false;
        int left = getLAC(root.left, p, q, ret)?1:0;
        int right = getLAC(root.right, p, q, ret) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if(left+mid+right>1)ret.val=root.val;
        // 注意这里是大于0，不要写成大于1
        return left+mid+right>0;
//        return left+mid+right>1;
    }
}
