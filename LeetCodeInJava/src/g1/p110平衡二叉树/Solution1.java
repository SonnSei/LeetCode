package g1.p110平衡二叉树;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 20:22
 * @Author SonnSei
 */
public class Solution1 {

    Map<TreeNode,Integer> map;
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        map = new HashMap<>();
        return Math.abs(getDepth(root.left) - getDepth(root.right)) > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if(map.containsKey(node))return map.get(node);
        if(node == null)return 0;
        int depth = Math.max(getDepth(node.left),getDepth(node.right))+1;
        map.put(node, depth);
        return depth;
    }
}
