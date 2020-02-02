package g0;

import util.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution95
 * @Description 不同的二叉搜索树 II
 * @Date 2020/1/9 15:32
 * @Author SonnSei
 */
public class Solution95 {

    public static  List<TreeNode> generateTrees(int n) {
        if(n <=0) return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new LinkedList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i+1, end);

            for(TreeNode left:leftTrees)
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
        }
        return ret;
    }
}
