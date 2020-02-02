package g0.p4寻找两个有序数组的中位数;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 13:44
 * @Author SonnSei
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k1 =(len1+len2+1)/2;
        int k2 = (len1+len2+2)/2;
        int v1 = getKthFromTwoArray(nums1,0,nums2,0,k1);
        int v2 = getKthFromTwoArray(nums1, 0, nums2, 0, k2);
        return (v1+v2)/2.0;
    }

    private int getKthFromTwoArray(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(start1>=nums1.length) return nums2[start2 + k - 1];
        if(start2>=nums2.length) return nums1[start1 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        int v1 = start1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE :nums1[start1 + k / 2 - 1];
        int v2 = start2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];

        if (v1 <v2) {
            return getKthFromTwoArray(nums1, start1+k/2 , nums2, start2, k - k / 2);
        }
        return getKthFromTwoArray(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
