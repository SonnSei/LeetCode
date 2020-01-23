package 树.p333最大BST子树;

import util.TreeNode;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 18:25
 * @Author SonnSei
 */
public class Solution1 {
    static int max;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)return 0;
        max= 1;
        recursive(root);
        return max;
    }

    // [当前子树是否是BST（1|0），当前子树最大值，当前子树最小值,子树节点数量]
    private int[] recursive(TreeNode node) {
        int[] ret = new int[]{1,node.val,node.val, 1};
        if (node.left != null) {
            int[] left = recursive(node.left);
            if (left[0] == 0 || node.val<=left[1]) {
                // 这个地方不能return，否则从根节点可能就断了
                ret[0]=0;
            }
            ret[3]+=left[3];
            ret[2] = left[2];
        }
        if (node.right != null) {
            int[] right = recursive(node.right);
            if (right[0] == 0 || node.val >= right[2]) {
                ret[0]=0;
            }
            ret[3]+=right[3];
            ret[1]=right[1];
        }
        if(ret[0]==1)
            max = Math.max(max, ret[3]);
        return ret;
    }
}
