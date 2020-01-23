package 树.p272最接近的二叉搜索树值Ⅱ;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 10:50
 * @Author SonnSei
 */
public class Solution1 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        List<Integer> ret = new ArrayList<>();
        int index = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i + 1) > target) {
                if (target - list.get(i) > list.get(i + 1) - target) i++;
                index = i;
                break;
            }
        }
        ret.add(list.get(index));
        int left = index - 1, right = index + 1;
        for (int i = 0; i < k - 1; i++) {
            Double diffLeft = left >= 0 ? target - list.get(left) : null;
            Double diffRight = right < list.size() ? list.get(right) - target : null;
            if (diffLeft == null || (diffRight != null && diffLeft > diffRight))
                ret.add(list.get(right++));
            else {
                ret.add(list.get(left--));
            }
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
