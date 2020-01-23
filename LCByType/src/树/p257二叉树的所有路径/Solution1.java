package 树.p257二叉树的所有路径;

import util.TreeNode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 23:00
 * @Author SonnSei
 */
public class Solution1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) return ret;
        dfs(root, ret, new ArrayList<String>());
        return ret;
    }

    private void dfs(TreeNode node, List<String> ret, List<String> tmp) {
        if (tmp.size() > 0)
            tmp.add("->");
        tmp.add(""+node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (String s : tmp) {
                sb.append(s);
            }
            ret.add(sb.toString());
            tmp.remove(tmp.size() - 1);
            if (tmp.size() > 0) {
                tmp.remove(tmp.size() - 1);
            }
            return;
        }

        if (node.left != null) {
            dfs(node.left, ret, tmp);
        }
        if (node.right != null) {
            dfs(node.right, ret, tmp);
        }
        tmp.remove(tmp.size() - 1);
        if (tmp.size() > 0) {
            tmp.remove(tmp.size() - 1);
        }
        return;
    }
}
