package g0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution30
 * @Description 串联所有单词的字串
 * @Date 2020/1/7 9:16
 * @Author SonnSei
 */
public class Solution30 {
    public static void main(String[] args) {
//        String s = "foobarfoobar";
//        String[] words = {"foo","bar"};

        String s = "barfoofoobarthefoobarman";
                String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s,words));
    }


    /**
     * RK+map记录词频
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if(s == null ||s.length()==0 || words==null||words.length==0)return ret;
        int wordLen = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>();
        int wordsHash = 0;
        int len = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                wordsHash+=c;
                len++;
            }
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        if(s.length()<len) return ret;
        int[] hashArr = new int[s.length() - len + 1];
        int tempHash = 0;
        for (int i = 0; i < len; i++) {
            tempHash += s.charAt(i);
        }
        hashArr[0] = tempHash;
        for (int i = len; i <s.length(); i++) {
            tempHash-=s.charAt(i-len);
            tempHash+=s.charAt(i);
            hashArr[i-len+1] = tempHash;
        }

        for (int i = 0; i <= s.length()-len; i++) {
            if(hashArr[i]!=wordsHash)continue;
            String seq = s.substring(i,i+len);
            Map<String, Integer> compareMap = new HashMap<>();
            boolean success = true;
            for (int j = 0; j <seq.length() ; j+=wordLen) {
                String key = seq.substring(j, j+wordLen);
                compareMap.put(key, compareMap.getOrDefault(key, 0) + 1);
                if (!wordsMap.containsKey(key) || compareMap.get(key) > wordsMap.get(key)) {
                    success = false;
                    break;
                }
            }
            if(success) ret.add(i);
        }
        return ret;
    }

    /**
     * 全排列 超时
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if(s == null ||s.length()==0 || words==null||words.length==0)return ret;
        List<String> permutations = new ArrayList<>();
        boolean[] used = new boolean[words.length];
        getPermutations(words, permutations, 0, used, new ArrayList<String>());
        for (String item : permutations) {
            int index =0;
            while ((index = s.indexOf(item, index)) > -1) {
                if(!ret.contains(index)) ret.add(index);
                index++;
            }
        }
        return ret;
    }

    private static void getPermutations(String[] words, List<String> list, int index, boolean[] used, List<String> temp) {
        if (index == words.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : temp)
                sb.append(s);
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            temp.add(words[i]);
            getPermutations(words, list, index + 1, used, temp);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
