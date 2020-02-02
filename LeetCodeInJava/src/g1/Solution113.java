package g1;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution113
 * @Description 113. 路径总和 II
 * @Date 2019/12/19 18:44
 * @Author SunCheng
 */
public class Solution113 {
    /**
     * 递归法：
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)return ret;
        backTracking(ret,root, 0, sum, new ArrayList<Integer>());
        return ret;
    }

    private void backTracking(List<List<Integer>> ret, TreeNode node, int tempSum, int target, ArrayList<Integer> record) {
        record.add(node.val);
        if (node.left == null && node.right == null && tempSum == target - node.val) {
            ret.add(new ArrayList<>(record));
            // 这个地方如果return的话，需要单独删除record的最后元素
//            return;
        }

        if (node.left != null) {
            backTracking(ret,node.left,tempSum+node.val,target,record);
        }

        if (node.right != null) {
            backTracking(ret,node.right,tempSum+node.val,target,record);
        }
        record.remove(record.size() - 1);
    }


}
