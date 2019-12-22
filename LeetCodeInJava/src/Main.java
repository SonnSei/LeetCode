
import java.util.*;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/12/18 19:22
 * @Created by SunCheng
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1000000007));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int val : nums) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            }else
                map.put(val, 1);
            min = val<min?val:min;
        }
        int start = min;
        while (!map.isEmpty()) {
            for (int i = 0; i < k; i++) {
                int num = start+i;
                if (!map.containsKey(num)) {
                    return false;
                }
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
            for (int i = 0; i < map.size(); i++) {
                if (!map.containsKey(start + i)) {
                    start++;
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
