package 树.p366寻找完全二叉树的叶子节点;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/23 20:31
 * @Author SonnSei
 */
public class Solution2 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        postOrder(ret, root);
        return ret;
    }

    // 返回的是以node为根的子树高度-1
    private int postOrder(List<List<Integer>> ret, TreeNode node) {
        if(node == null) return 0;
        int leftDepth = postOrder(ret, node.left);
        int rightDepth = postOrder(ret, node.right);
        int depth = Math.max(leftDepth, rightDepth);
        while (ret.size() < depth + 1) {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(node.val);
        return depth+1;
    }
}
