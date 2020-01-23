package 树.p270最接近的二叉搜索树值;

import util.TreeNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 10:26
 * @Author SonnSei
 */
public class Solution1 {

    // 不能只判断与子节点的关系
//    public int closestValue(TreeNode root, double target) {
//        double diffMid = Math.abs(target-root.val);
//        double diffLeft = root.left!=null?Math.abs(target-root.left.val):diffMid+1;
//        double diffRight = root.right!=null?Math.abs(target-root.right.val):diffMid+1;
//        if( diffRight<diffMid) return closestValue(root.right, target);
//        if(diffLeft<diffMid) return closestValue(root.left, target);
        // 没必要判断target是否大于root.val
//        if(target> root.val && diffRight<diffMid) return closestValue(root.right, target);
//        if(target<root.val&&diffLeft<diffMid) return closestValue(root.left, target);
//        return root.val;
//    }

    int ret;
    public int closestValue(TreeNode root, double target) {
        ret = root.val;
        recursive(root, target);
        return ret;
    }

    private void recursive(TreeNode node, double target) {
        double diff = Math.abs(target - node.val);
        if (diff < Math.abs(target - ret)) {
            ret = node.val;
        }
        if(node.left!=null &&target<node.val)recursive(node.left,target);
        if(node.right!=null && target>node.val)recursive(node.right,target);
    }
}
