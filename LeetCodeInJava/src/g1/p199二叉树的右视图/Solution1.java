package g1.p199二叉树的右视图;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 20:31
 * @Author SonnSei
 */
public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
            }
        }
        return ret;
    }
}
