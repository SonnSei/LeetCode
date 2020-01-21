package 树.p103二叉树的锯齿形层次遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/21 19:00
 * @Author SonnSei
 */
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(root == null)return ret;
        leftStack.push(root);
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            tmp.clear();
            if (!leftStack.isEmpty()) {
                while (!leftStack.isEmpty()) {
                    TreeNode node = leftStack.pop();
                    tmp.add(node.val);
                    if (node.left != null) rightStack.push(node.left);
                    if (node.right != null) rightStack.push(node.right);
                }
            } else {
                while (!rightStack.isEmpty()) {
                    TreeNode node = rightStack.pop();
                    tmp.add(node.val);
                    if(node.right!=null) leftStack.push(node.right);
                    if(node.left!=null) leftStack.push(node.left);
                }
            }
            ret.add(new ArrayList<>(tmp));
        }
        return ret;
    }
}
