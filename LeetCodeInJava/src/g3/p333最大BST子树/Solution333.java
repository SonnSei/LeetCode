package g3.p333最大BST子树;

import util.TreeNode;

import java.util.*;

/**
 * @Classname Solution333
 * @Description 最大 BST 子树
 * @Date 2020/1/8 11:20
 * @Author SonnSei
 */
public class Solution333 {
    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        max = Math.max(max, isBST(root));
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return max;
    }

    int isBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int pre = Integer.MIN_VALUE;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (pre >= node.val) {
                    return -1;
                }
                pre = node.val;
                list.add(node.val);
                node = node.right;
            }
        }
        return list.size();
    }


    /**
     * 这个递归再加一个getCount比上面的非递归要快
     * @param root
     * @return
     */
//    private boolean isBST(TreeNode root) {
//        if (root == null) return true;
//        boolean leftFlag = isBST(root.left);
//        if (preVal >= root.val) return false;
//        preVal = root.val;
//        boolean rightFlag = isBST(root.right);
//        return leftFlag && rightFlag;
//    }

}
