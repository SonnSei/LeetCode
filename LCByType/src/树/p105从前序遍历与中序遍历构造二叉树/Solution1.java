package 树.p105从前序遍历与中序遍历构造二叉树;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 19:46
 * @Author SonnSei
 */
public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 下面这个是错的
//        if (preStart == preEnd) {
//            return new TreeNode(pre[preStart]);
//        }
        TreeNode ret = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == ret.val) {
                ret.left = buildTree(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                ret.right = buildTree(pre, i - inStart + preStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return ret;
    }
}
