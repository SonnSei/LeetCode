package g1;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution114
 * @Description 二叉树展开为链表
 * @Date 2019/12/19 19:22
 * @Author SunCheng
 */
public class Solution114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        Solution114 solution = new Solution114();
        solution.flatten(root);

    }

    /**
     * 自己写的很low的
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        root = change(root);
    }

    private TreeNode change(TreeNode root) {
        if(root == null)return null;
        if (root.left == null && root.right == null) return root;
        else if (root.left == null) {
            root.right = change(root.right);
        } else if (root.right == null) {
            root.left = change(root.left);
            root.right = root.left;
            root.left =null;
        } else {
            TreeNode right = change(root.right);
            root.right = change(root.left);
            root.left = null;
            TreeNode cur = root.right;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right;
        }
        return root;
    }

    private TreeNode pre = null;
    /**
     * 后续遍历递归 改
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // ！！！！！体会这种 右-左-中的遍历方式
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }


    /**
     * 后续迭代 改
     * @param root
     */
    public void flatten3(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {
                toVisit.pop();
                /**************修改的地方***************/
                cur.right = pre;
                cur.left = null;
                /*************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }

}
