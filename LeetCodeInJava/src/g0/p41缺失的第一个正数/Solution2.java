package g0.p41缺失的第一个正数;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/9 18:23
 * @Author SonnSei
 */
public class Solution2 {
    // 这个代码与官方题解不一样，但是更能体现出思路
    // 题目要求常数级的空间复杂度，所以不能有额外空间，
    // ---》由此想到，比如遇到i处的元素为x，通过对x处元素做修改，来表现出x号元素已经出现
    // ---》既要表现出x已经出现，又不能影响x处本来元素的使用
    // ---》想到通过正负号来处理
    // 但是数组中可能原来就有负数元素，从而会影响到之后的判断
    // 再考虑到长度为n的数组，其结果只能在【1，n+1】之间，
    // 我们的判断逻辑是用0号位表示n，所以整个数组表示【1，n】之间是否出现
    // 如果【1，n】全部出现，那就返回n+1
    // 所以特殊值可取n+1，只要是大于n就可以（极端情况下可能溢出，官方题解在对1进行判断后用的1）
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)return 1;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i] = nums.length+1;
            }
        }

        for(int i = 0;i<nums.length;i++){
            int cur = Math.abs(nums[i]);
            if(cur>0 && cur<nums.length){
                nums[cur] = -Math.abs(nums[cur]);
            }else if( cur==nums.length){
                nums[0] = -Math.abs(nums[0]);
            }
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>0)return i;
        }
        if(nums[0]>0)return nums.length;
        return nums.length+1;
    }
}
