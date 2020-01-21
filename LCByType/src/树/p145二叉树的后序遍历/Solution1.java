package 树.p145二叉树的后序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 23:32
 * @Author SonnSei
 */
public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
