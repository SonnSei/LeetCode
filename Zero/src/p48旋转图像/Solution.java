package p48旋转图像;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/13 22:05
 * @Author SonnSei
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null ||matrix.length<2)return;
        change(matrix);
        for(int[] row:matrix){
            reverse(row);
        }
    }

    private void change(int[][] nums){
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                swap(nums,i,j,j,i);
            }
        }
    }

    private void swap(int[][] nums, int x1,int y1,int x2,int y2){
        int tmp = nums[x1][y1];
        nums[x1][y1] = nums[x2][y2];
        nums[x2][y2] = tmp;
    }

    private void reverse(int[] nums){
        for(int i = 0;i<nums.length/2;i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
