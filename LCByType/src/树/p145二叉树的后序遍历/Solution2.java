package 树.p145二叉树的后序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/21 23:36
 * @Author SonnSei
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while(cur != null || !stack.empty()){

            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(cur.right == null || pre == cur.right){
                res.add(cur.val);
                pre = cur;
                cur = null;
            }
            else{
                stack.push(cur);
                cur = cur.right;
            }
        }
        return res;
    }
}
