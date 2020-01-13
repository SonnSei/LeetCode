package p35搜索插入位置;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/13 18:46
 * @Author SonnSei
 */
public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos<0?-pos-1:pos;
    }
}
