package g1.p106从中序遍历与后序遍历构造二叉树;

import util.TreeNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 20:02
 * @Author SonnSei
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
        if (postorder.length != inorder.length) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inStart>inEnd)return null;
        TreeNode ret = new TreeNode(post[postEnd]);
        for (int i = inStart; i <=inEnd ; i++) {
            if (in[i] == ret.val) {
                ret.left = buildTree(in, inStart, i-1, post, postStart, postStart + i - inStart - 1);
                ret.right = buildTree(in, i + 1, inEnd, post, postStart + i - inStart , postEnd-1);
            }
        }
        return ret;
    }
}
