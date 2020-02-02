package g2.p222完全二叉树的节点个数;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 20:46
 * @Author SonnSei
 */
public class Solution1 {

    public int countNodes(TreeNode root) {
        int ret = 0;
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ret+=size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
            }
        }
        return ret;
    }

}
