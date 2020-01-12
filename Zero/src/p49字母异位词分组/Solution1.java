package p49字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/12 22:47
 * @Author SonnSei
 */
public class Solution1 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        for(String str:strs){
            boolean find = false;
            for(int i = 0;i<ret.size();i++){
                if(check(str,ret.get(i).get(0))){
                    ret.get(i).add(str);
                    find = true;
                    break;
                }
            }
            if(!find){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                ret.add(newList);
            }
        }
        return ret;
    }

    private static boolean check(String s1,String s2){
        if(s1.length() != s2.length())return false;
        char[] c1=s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        Arrays.sort(c1);
        for(int i = 0 ; i < c1.length;i++){
            if(c1[i]!=c2[i])return false;
        }
        return true;
    }
}
