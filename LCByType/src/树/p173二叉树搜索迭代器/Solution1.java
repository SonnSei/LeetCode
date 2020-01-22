package 树.p173二叉树搜索迭代器;

import util.TreeNode;

import java.util.LinkedList;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 11:27
 * @Author SonnSei
 */
public class Solution1 {
    class BSTIterator {

        LinkedList<TreeNode> queue;
        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            TreeNode node = root;
            while (node != null) {
                queue.addLast(node);
                node = node.right;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = queue.getFirst();
            if(node.left==null)return queue.removeFirst().val;
            while (node.left != null && node.left.left!=null) {
                node = node.left;
            }
            TreeNode ret = node.left;
            node.left = ret.right;
            ret.right = null;
            return ret.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
