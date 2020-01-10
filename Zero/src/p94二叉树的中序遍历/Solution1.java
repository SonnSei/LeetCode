package p94二叉树的中序遍历;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 16:36
 * @Author SonnSei
 */
public class Solution1 {
    /**
     * 莫里斯中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
}
