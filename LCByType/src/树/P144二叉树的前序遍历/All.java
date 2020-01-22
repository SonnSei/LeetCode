package 树.P144二叉树的前序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname All
 * @Description
 * @Date 2020/1/22 10:34
 * @Author SonnSei
 */
public class All {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null)
            return ret;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            ret.add(curNode.val);

            if (curNode.right != null)
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
        return ret;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
