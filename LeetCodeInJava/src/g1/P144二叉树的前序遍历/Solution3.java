package g1.P144二叉树的前序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/1/21 23:03
 * @Author SonnSei
 */
public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        preOrderMorris(root, ret);
        return ret;
    }

    private void preOrderMorris(TreeNode node, List<Integer> ret) {
        TreeNode cur = node;
        while (cur != null) {
            if (cur.left == null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode next = cur.left;
                while (next.right != null && next.right != cur) {
                    next = next.right;
                }
                if (next.right == null) {
                    next.right = cur;
                    ret.add(cur.val);
                    cur = cur.left;
                } else {
                    next.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}
