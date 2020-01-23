package 树.p366寻找完全二叉树的叶子节点;

import util.TreeNode;

import java.util.*;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 19:42
 * @Author SonnSei
 */
public class Solution1 {
    boolean flag;
    Set<TreeNode> set;
    Set<TreeNode> tmpSet;
    List<List<Integer>> ret;
    public List<List<Integer>> findLeaves(TreeNode root) {
         ret= new ArrayList<>();
         tmpSet = new HashSet<>();
         set = new HashSet<>();
        if(root == null)return ret;

        flag = true;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (flag) {
            flag = false;
            tmp.clear();
            tmp.clear();
            postOrder(root, tmp);
            ret.add(new ArrayList<>(tmp));
            set.addAll(tmpSet);
        }
        return ret;

    }

    private void postOrder(TreeNode node, ArrayList<Integer> tmp) {
        if(node==null)return;
        postOrder(node.left, tmp);
        postOrder(node.right, tmp);
        if(set.contains(node))return;
        if ((node.left == null || set.contains(node.left)) && (node.right == null || set.contains(node.right))) {
            tmp.add(node.val);
            tmpSet.add(node);
        } else {
            flag = true;
        }
    }
}
