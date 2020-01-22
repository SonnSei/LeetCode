package 树.p250统计同值子树;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 22:13
 * @Author SonnSei
 */
public class Solution1 {
    int cnt;
    public int countUnivalSubtrees(TreeNode root) {
        cnt = 0;
        recurseTree(root);
        return cnt;
    }

    private boolean recurseTree(TreeNode root) {
        if(root == null)return true;
        if (root.left == null && root.right == null) {
            cnt++;
            return true;
        }
        boolean left = recurseTree(root.left);
        boolean right = recurseTree(root.right);
        if (root.left == null ) {
            if (right && root.val == root.right.val) {
                cnt++;
                return true;
            }
        } else if (root.right == null ) {
            if (left && root.val == root.left.val) {
                cnt++;
                return true;
            }
        } else if(left && right && root.val == root.left.val && root.val == root.right.val) {
            cnt++;
            return true;
        }
        return false;
    }

// 注意看下面if判断那里，为什么会出错？
//    private boolean recurseTree(TreeNode root) {
//        if(root == null)return true;
//        if (root.left == null && root.right == null) {
//            cnt++;
//            return true;
//        }
//        boolean left = root.left == null ? true : recurseTree(root.left);
//        boolean right = root.right == null ? true : recurseTree(root.right);
//        if (root.left == null && right && root.val == root.right.val) {
//            cnt++;
//            return true;
//        } else if (root.right == null && left && root.val == root.left.val) {
//            cnt++;
//            return true;
//        } else if(left && right && root.val == root.left.val && root.val == root.right.val) {
//            cnt++;
//            return true;
//        }
//        return false;
//    }
}
