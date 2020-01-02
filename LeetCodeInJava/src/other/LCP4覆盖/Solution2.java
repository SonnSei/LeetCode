package other.LCP4覆盖;

import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/1 12:51
 * @Author SonnSei
 */
// 匈牙利算法
class Solution2 {
    public int domino(int n, int m, int[][] broken) {
        return 0;
    }

    class Hungary {

        boolean[] used;
        boolean[][] map;
        int[] matchX;
        int[] matchY;
        int[] V1;
        int[] V2;

        public int hungary() {
            int ret = 0;
            for (int i = 0; i < V1.length; i++) {
                Arrays.fill(used, false);
                if (find(V1[i]))ret++;
            }
            for (int i = 0; i < matchX.length; i++) {
                if(matchX[i]==-1)continue;
                System.out.println(i+"--"+matchX[i]);
            }
            return ret;
        }

        public Hungary(int x, int y,boolean[][] map,int[] v1,int[] v2) {
            used = new boolean[y+x];
            this.map = map;
            matchX = new int[x+y];
            matchY = new int[y+x];
            Arrays.fill(matchX, -1);
            Arrays.fill(matchY, -1);
            V1 = v1;
            V2 = v2;
        }

        private boolean find(int x) {
            for (int i = 0; i< V2.length; i++) {
                int y = V2[i];
                if (map[x][y] && !used[y]) {
                    used[y]=true;
                    if (matchY[y] == -1 || find(matchY[y])) {
                        matchX[x]=y;
                        matchY[y]=x;
                        return true;
                    }
                }
            }
            return false;
        }
    }


}