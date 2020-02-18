package g0.p66加一;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/18 9:53
 * @Author SonnSei
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]+1<10){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
