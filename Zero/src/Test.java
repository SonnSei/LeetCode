import java.util.Arrays;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/1/10 15:58
 * @Author SonnSei
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{3,8,3, 3, 3, 1, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        int pivot = nums[0];
        int leftCount = 0,rightCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<pivot)leftCount++;
            if(nums[i]>pivot)rightCount++;
        }
        int[] tmp = new int[nums.length];
        int left = 0, right = nums.length - 1;
        Arrays.fill(tmp, pivot);
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(value<pivot)tmp[left++] = value;
            if(value>pivot)tmp[right--] = value;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }
    

}
