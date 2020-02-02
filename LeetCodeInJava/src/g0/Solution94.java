package g0;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution94
 * @Description 二叉树的中序遍历
 * @Date 2020/1/10 7:56
 * @Author SonnSei
 */
public class Solution94 {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  ret = new ArrayList<>();
        inOrder(root,ret);
        return ret;
    }


    private static void inOrder(TreeNode node,List<Integer> list){
        if(node == null)return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer>  ret = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node =stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }
        return ret;
    }


    /**
     * 莫里斯遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    ret.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ret;
    }

}
