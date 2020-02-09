package g0.p94二叉树的中序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/10 16:46
 * @Author SonnSei
 */
public class Solution2 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root, ret);
        return ret;
    }

    private void inOrder(TreeNode root, List<Integer> ret) {
        if (root == null) return;
        inOrder(root.left,ret);
        ret.add(root.val);
        inOrder(root.right,ret);
    }
}
