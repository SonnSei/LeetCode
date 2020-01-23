package 树.p285二叉搜索树中的顺序后继;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 11:52
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode ret = new Solution1().inorderSuccessor(node2, node1);
        System.out.println(ret==null?null:ret.val);
    }

    TreeNode ret;
    TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode node = p.right;
            // 这个地方有次错写成 node != null
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        ret = null;
        pre = null;
        inorder(root, p);
        return ret;
    }

    private void inorder(TreeNode node, TreeNode p) {
        if(node == null||ret!=null)return;
        inorder(node.left, p);

        // 考虑下面这个为什么不行
        // pre==p之后跳出循环，但是此时的pre一直指向p，也就是之后的判断都会认为pre==p
//        if (pre != null && pre==p) {
//            ret = node;
//            return;
//        } else {
//            pre = node;
//        }

        if (pre != null && pre == p)
            ret = node;
        pre = node;
        inorder(node.right, p);
    }
}
