package p490迷宫;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/11 1:45
 * @Author SonnSei
 */
public class Solution2 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0],y = cur[1];
            visited[x][y] = true;
            if(x == destination[0] && y == destination[1])return true;
            // 有一次maze里面的tmp忘记修改了
            int tmp = x;
            while(tmp-1>=0 && maze[tmp-1][y]==0)tmp-=1;
            if(!visited[tmp][y])queue.add(new int[]{tmp,y});
            tmp = x;
            while(tmp+1<maze.length && maze[tmp+1][y]==0)tmp+=1;
            if(!visited[tmp][y])queue.add(new int[]{tmp,y});
            tmp = y;
            while(tmp-1>=0 && maze[x][tmp-1]==0)tmp-=1;
            if(!visited[x][tmp])queue.add(new int[]{x,tmp});
            tmp = y;
            while(tmp+1<maze[0].length && maze[x][tmp+1]==0)tmp+=1;
            if(!visited[x][tmp])queue.add(new int[]{x,tmp});
        }
        return false;
    }




}
