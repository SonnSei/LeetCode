package g0;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution98
 * @Description 验证二叉搜索树
 * @Date 2020/1/9 16:19
 * @Author SonnSei
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode node,Integer lower,Integer higher){
        if(node == null)return true;
        if(lower!=null && node.val<=lower)return false;
        if(higher!=null && node.val>=higher)return false;
        if(!isValidBST(node.left,lower,node.val))return false;
        if(!isValidBST(node.right,node.val,higher))return false;
        return true;
    }



    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Integer pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur != null) {
                if(pre!=null && cur.val<=pre)return false;
                pre = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}
