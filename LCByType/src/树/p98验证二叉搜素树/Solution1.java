package 树.p98验证二叉搜素树;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/19 22:35
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node =node.left;
            }
            node = stack.pop();
            if(pre==null){
                pre= node;
            }else{
                if(pre.val>=node.val)return false;
                // 有一次下面这句忘记写了
                pre = node;
            }
            node = node.right;
        }
        return true;
    }
}
