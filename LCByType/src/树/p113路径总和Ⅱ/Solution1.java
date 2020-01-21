package 树.p113路径总和Ⅱ;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 20:40
 * @Author SonnSei
 */
public class Solution1 {
    List<List<Integer>> ret;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<>();
        if(root == null)return ret;
        dfs(root, 0, sum, new ArrayList<Integer>());
        return ret;
    }

    private void dfs(TreeNode node, int tempSum, int sum, ArrayList path) {
        if(node ==null)return;
        tempSum+=node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && tempSum == sum) {
            ret.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(node.left, tempSum, sum, path);
        dfs(node.right, tempSum, sum, path);
        path.remove(path.size() - 1);
    }
}
