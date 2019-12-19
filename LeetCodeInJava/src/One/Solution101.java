package One;


import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution101
 * @Description 对称二叉树
 * @Date 2019/12/19 10:22
 * @Author SunCheng
 */
public class Solution101 {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 巧妙的迭代方法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    /**
     * 笨拙的迭代方法
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size  = queue.size();
            ArrayList<Integer> curLevel= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    curLevel.add(curNode.val);
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                } else {
                    curLevel.add(null);
                }
            }
            lists.add(new ArrayList<>(curLevel));
        }
        for (ArrayList<Integer> list : lists) {
            if (!symmetric(list)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测某个list中的元素是否是对称的
     * @param list
     * @return
     */
    private boolean symmetric(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Integer value = list.get(i);
            if (value == null && list.get(list.size() - i - 1) != null) {
                return false;
            }
            if (value!=null && !value.equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
