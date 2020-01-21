package 树.p95不同的二叉搜素树Ⅱ;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/19 22:04
 * @Author SonnSei
 */
public class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        if(n<1) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if (start < end) {
            ret.add(null);
            return ret;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ret.add(node);
                }
            }
        }
        return ret;
    }
}
