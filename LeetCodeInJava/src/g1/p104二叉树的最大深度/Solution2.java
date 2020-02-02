package g1.p104二叉树的最大深度;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/21 19:43
 * @Author SonnSei
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        int ret = 0;
        if(root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ret++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return ret;
    }
}
