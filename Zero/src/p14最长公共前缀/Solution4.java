package p14最长公共前缀;

/**
 * @Classname Solution4
 * @Description TODO
 * @Date 2020/1/12 8:21
 * @Author SonnSei
 */
public class Solution4 {
    /**
     * 二分查找
     * 时间复杂度：O（S*log(n))
     * 空间复杂度：O（1）
     * @param strs
     * @return
     */
    public String longestCommonPrefix4(String[] strs) {
        if(strs==null || strs.length == 0)return "";
        int minLen = strs[0].length();
        for(String item:strs)
            minLen = Math.min(minLen, item.length());
        int left = 0,right = minLen;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(isCommonPrefix(strs,mid))
                left = mid+1;
            else
                right =mid-1;
        }


        /*
         * 这里为什么要是right?
         * 其实一开始是写的Math.min(left,right)，但是后来发现直接用right就行
         * 假如最后一次left==right之后做判断，
         * 如果为true，left右移，但最后结果要取right
         * 如果为false，right左移，还是取right
         * 有没有考虑right左移变成-1的时候越界？
         * 当left==right==0的时候，判定会是true，会left右移，所以right不会越界
         */
        return strs[0].substring(0, right);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
