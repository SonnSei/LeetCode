package g1;

import util.TreeNode;

/**
 * @Classname Solution105
 * @Description TODO
 * @Date 2019/12/19 15:25
 * @Author SunCheng
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ret = buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return ret;
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (inStart>inEnd||preStart>preEnd) {
            return null;
        }
        TreeNode ret = new TreeNode(pre[preStart]);
        int key = pre[preStart];
        for (int i = inStart; i <=inEnd ; i++) {
            if (in[i] == key) {
                ret.left = buildTree(pre, preStart+1, i - inStart + preStart, in, inStart, i-1);
                ret.right = buildTree(pre, i - inStart + preStart + 1, preEnd, in, i+1, inEnd);
                break;
            }
        }
        return ret;
    }
}
