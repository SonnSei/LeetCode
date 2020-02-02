package g2.p230二叉搜索树中第K小的元素;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 21:22
 * @Author SonnSei
 */
public class Solution1 {
    int cnt;
    int ret;
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        ret = 0;
        inOrder(root,k);
        return ret;
    }

    private void inOrder(TreeNode node, int k) {
        if(node == null)return;
        inOrder(node.left,k);
        if(++cnt == k)ret =node.val;
        inOrder(node.right,k);
    }
}
