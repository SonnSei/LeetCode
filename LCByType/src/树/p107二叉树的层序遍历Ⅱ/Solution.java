package 树.p107二叉树的层序遍历Ⅱ;

import util.TreeNode;

import java.util.*;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 20:12
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(new ArrayList<>(curLevel));
        }
        Collections.reverse(ret);
        return ret;
    }

}
