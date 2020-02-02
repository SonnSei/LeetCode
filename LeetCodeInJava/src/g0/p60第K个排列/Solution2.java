package g0.p60第K个排列;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/15 15:01
 * @Author SonnSei
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.getPermutation(2,2));
    }

    public String getPermutation(int n, int k) {
        if(n==1) return "1";
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, k, visited);
    }

    private String recursive(int n,  int k, boolean[]visited){
        int interval = factorial(n)/n;
        int offset = k%interval;
        int groupIndex = k/interval+(offset==0?0:1);
        // 从visisted取出第groupIndex个未使用的数
        int cnt = 0;
        int i = 0;
        while (cnt < groupIndex) {
            if(!visited[i])cnt++;
            i++;
        }
        int digit = i;
        visited[i-1]=true;
        if(n==1)
            return ""+digit;
        return digit + recursive(n-1,offset==0?interval:offset , visited);
    }

    /**
     * 求 n!
     */
    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }
}
