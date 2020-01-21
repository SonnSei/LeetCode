package 树.p99恢复二叉搜素树;

import util.TreeNode;

import java.util.Stack;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/19 22:43
 * @Author SonnSei
 */
public class Solution1 {
    public void recoverTree(TreeNode root) {
        if(root == null)return;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode node = root;
        TreeNode pre = null;
        TreeNode last = null;

        Stack<TreeNode> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(pre == null){
                pre = node;
            }else{
                if(pre.val>=node.val){
                    if(firstNode==null){
                        firstNode = pre;
                        // 为什么要下面这一句？
                        // 如果是相邻两个元素替换，那么下面那个else是无法进入的
                        // 1，2，3，4，5--->3，2，1，4，5 这种情况是不需要下一句的，
                        // 因为两个异常点是分了两次找到
                        // 1，2，3，4，5---->1，3，2，4，5 这种情况如果没有下一句，就无法找到
                        // 因为两个异常点是在一次检查中找到，没有第二次机会
                        secondNode = node;
                    }else{
                        secondNode = node;
                        break;
                    }
                }
                pre = node;
            }
            node = node.right;
        }
        if(firstNode!=null && secondNode!=null){
            int tmp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val =tmp;
        }
    }
}
