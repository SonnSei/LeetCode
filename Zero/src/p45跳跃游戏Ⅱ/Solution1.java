package p45跳跃游戏Ⅱ;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/13 22:52
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(new Solution1().jump(nums));
    }

    int min;
    int step;

    /**
     * dfs超时
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums==null ||nums.length<2)return 0;
        min = nums.length;
        step = 0;
        dfs(nums,0,0);
        return min;
    }

    private void dfs(int[] nums, int index,int step) {
        if (index == nums.length - 1) {
            min = Math.min(min,step);
            return;
        }
        int move = nums[index];
        for (int i = 1; i <=move; i++) {
            if (i + index < nums.length) {
                dfs(nums, index + i, step + 1);
            }
        }
    }
}
