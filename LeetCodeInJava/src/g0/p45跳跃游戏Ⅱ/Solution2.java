package g0.p45跳跃游戏Ⅱ;

import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/12 10:42
 * @Author SonnSei
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        // 注意这里返回的是  nums.length-1
        if(nums.length<3)return nums.length-1;
        int n = nums.length;
        int[][] map = new int[n][n];
        for(int[] row:map)
            Arrays.fill(row,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            map[i][i]=1;
            int move = nums[i];
            for (int j = 1; j <=move&&i+j<n ; j++) {
                map[i][i+j]=1;
            }
        }

        return dijkstra(map,0,n-1);

    }

    static final int N = Integer.MAX_VALUE;
    public static int dijkstra(int[][] map, int start, int end) {
        int n = map.length;
        int[] dist = new int[n];
        int[] p = new int[n];
        boolean[] flag = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = map[start][i];
            p[i] = start;
        }
        p[start] = start;
        dist[start] = 0;
        flag[start] = true;

        for (int i = 0; i < n; i++) {
            int temp = N, t = start;
            //找到P-V中距离最短的
            for (int j = 0; j < n; j++)
                if (!flag[j] && dist[j] < temp) {
                    t = j;
                    temp = dist[j];
                }

            if (t == start)
                break;
            flag[t] = true;
            for (int k = 0; k < n; k++) {
                if (!flag[k] && map[t][k] < N)
                    if (dist[k] > dist[t] + map[t][k]) {
                        dist[k] = dist[t] + map[t][k];
                        p[k] = t;
                    }
            }
        }

        return dist[end];

    }
}
