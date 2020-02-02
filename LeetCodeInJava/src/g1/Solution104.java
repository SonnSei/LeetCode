package g1;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution104
 * @Description 二叉树的最大深度
 * @Date 2019/12/19 14:47
 * @Author SunCheng
 */
public class Solution104 {
    /**
     * 递归方式
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 迭代方式：就是二叉树层序遍历的深度
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return 0;
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
        return ret.size();
    }




}
