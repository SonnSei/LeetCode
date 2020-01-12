package p4寻找两个有序数组的中位数;

/**
 * @Classname Solution1
 * @Description 寻找两个有序数组的中位数
 * @Date 2020/1/10 17:34
 * @Author SonnSei
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int val1 = getKthFromTwoArray(nums1, 0, nums2, 0, (length1 + length2 + 2) / 2);
        int val2 = getKthFromTwoArray(nums1, 0, nums2, 0, (length1 + length2 + 1) / 2);
        return (val1 + val2) / 2.0;
    }

    private int getKthFromTwoArray(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int temp1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int temp2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (temp1 < temp2)
            return getKthFromTwoArray(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        return getKthFromTwoArray(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
