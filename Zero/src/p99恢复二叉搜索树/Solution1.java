package p99恢复二叉搜索树;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description 恢复二叉搜索树
 * @Date 2020/1/10 15:41
 * @Author SonnSei
 */
public class Solution1 {

    /**
     * 利用莫里斯中序遍历
     * @param root
     */
    public static void recoverTree(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;

        TreeNode mostRight = null;
        TreeNode cur = root;

        TreeNode pre = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {  // 第二次遍历到了
                    mostRight.right = null;
                }
            }

            // 找到第一个不符合条件的和最后一个不符合条件的
            if (pre != null && pre.val > cur.val) {
                node1 = node1 == null ? pre : node1;
                node2 = cur;
            }

            pre = cur;
            cur = cur.right;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
