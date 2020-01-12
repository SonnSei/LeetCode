package p67二进制求和;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/13 0:19
 * @Author SonnSei
 */
public class Solution1 {
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        reverse(charsA);
        reverse(charsB);
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(charsA.length,charsB.length); i++) {
            int v1 = i>=charsA.length?0:(charsA[i]-'0');
            int v2 = i>=charsB.length?0:(charsB[i]-'0');
            ret.append((v1+v2+carry)%2);
            carry = (v1+v2+carry)/2;
        }
        if (carry>0)ret.append(1);
        return ret.reverse().toString();
    }

    private void reverse(char[] chars) {
        for (int i = 0; i < chars.length/2; i--) {
            swap(chars,i,chars.length-1-i);
        }
    }
    public static void swap(char[] nums,int a,int b){
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
