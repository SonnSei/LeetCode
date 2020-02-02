package g2.p222完全二叉树的节点个数;

import util.TreeNode;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/22 21:00
 * @Author SonnSei
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if(root ==null)
            return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            return (1 << leftLevel) + countNodes(root.right);
        } else {
            return (1 << rightLevel) + countNodes(root.left);
        }
    }

    private int countLevel(TreeNode node) {
        int ret = 0;
        while (node != null) {
            ret++;
            node =node.left;
        }
        return ret;
    }
}
