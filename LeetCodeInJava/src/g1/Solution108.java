package g1;

import util.TreeNode;

/**
 * @Classname Solution108
 * @Description TODO
 * @Date 2019/12/19 16:13
 * @Author SunCheng
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)return null;
        TreeNode root = sortedArrayToBST(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right)return null;
        int mid = (left+right)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
