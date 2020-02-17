package g3.p378有序矩阵中第K小的元素;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/14 10:08
 * @Author SonnSei
 */
public class Solution2 {
    // 时间复杂度O（lgX），其中X为数组中最大值与最小值的差值
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        // 思路就是以二分方式从数组范围（并非存在于数组中）取一个数，然后判断小于等于它的
        // 数字个数
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            // 求出小于等于mid的数字个数
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        // 为什么返回值一定在数组中？
        // 比如1，2，3，4，【5】，其中5是mid值，是不在数组中的，我们要找的是4
        // 之后hi会到5，在之后lo会一直移动到四，此时count是等于4的，导致hi左移
        // 此时跳出了循环，而lo此时一定是在数组中的
        return lo;
    }
}
