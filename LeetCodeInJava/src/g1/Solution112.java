package g1;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution112
 * @Description 112. 路径总和
 * @Date 2019/12/19 18:04
 * @Author SunCheng
 */
public class Solution112 {
    static boolean ret;

    /**
     * 递归方式一：
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        ret = false;
        if (root == null) return ret;
        backTracking(root, sum, 0);
        return ret;
    }

    private void backTracking(TreeNode root, int target, int sum) {
        if (ret) return;
        if (root.left == null && root.right == null) {
            if (target == sum + root.val) {
                ret = true;
                return;
            }
        }
        if (root.left != null) {
            backTracking(root.left, target, sum + root.val);
        }
        if (root.right != null) {
            backTracking(root.right, target, sum + root.val);
        }
    }

    /**
     * 递归二：
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    /**
     * 迭代：
     * 要感受这种 一个数据栈 一个状态栈 的思想
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode cur = nodeStack.pop();
            int curSum = sumStack.pop();
            if (cur.left == null && cur.right == null && curSum == sum) {
                return true;
            }
            if (cur.right != null) {
                nodeStack.push(cur.right);
                sumStack.push(curSum + cur.right.val);
            }
            if (cur.left != null) {
                nodeStack.push(cur.left);
                sumStack.push(curSum + cur.left.val);
            }
        }
        return false;
    }
}
