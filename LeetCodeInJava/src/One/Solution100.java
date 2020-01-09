package One;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution100
 * @Description 相同的树
 * @Date 2020/1/9 16:53
 * @Author SonnSei
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 根据遍历序列并不能确定树的结构，只能确定 二叉搜索树的结构

}
