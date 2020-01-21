package 树.P144二叉树的前序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 22:56
 * @Author SonnSei
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preOrder(root, ret);
        return ret;
    }

    private void preOrder(TreeNode node, List<Integer> ret) {
        if(node == null)return;
        ret.add(node.val);
        preOrder(node.left,ret);
        preOrder(node.right,ret);
    }
}
