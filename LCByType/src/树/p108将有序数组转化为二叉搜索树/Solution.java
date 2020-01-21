package 树.p108将有序数组转化为二叉搜索树;

import util.TreeNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 20:16
 * @Author SonnSei
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        // 【0，1】--> mid == 0
        // 然后 mid-1 = -1，就会非法索引
//        if(start==end) return new TreeNode(nums[start]);

        if(start>end)return null;
        int mid = (start+end)>>>1;
        TreeNode ret = new TreeNode(nums[mid]);
        ret.left = sortedArrayToBST(nums, start, mid - 1);
        ret.right = sortedArrayToBST(nums, mid + 1, end);
        return ret;
    }
}
