package other;

import javafx.util.Pair;

import java.util.*;

/**
 * @Classname Solution5305
 * @Description 5305. 获取你好友已观看的视频
 * @Date 2020/1/6 7:57
 * @Author SonnSei
 */
public class Solution5305 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < friends.length; i++) {
            int[] friend = friends[i];
            for (int val : friend) {
                map[i][val] = true;
                map[val][i] = true;
            }
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited[id] = true;
        for (int i = 0; i < level; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                for (int k = 0; k < n; k++) {
                    // 要在这里改变visited，否则依然可能出现重复
                    if (map[cur][k] == true && !visited[k]) {
                        queue.add(k);
                        visited[k] = true;
                    }
                }
            }
        }
        Map<String, Integer> hashMap = new HashMap<>();
        for (int item : queue) {
            List<String> videos = watchedVideos.get(item);
            for (String video : videos) {
                hashMap.put(video, hashMap.getOrDefault(video, 0) + 1);
            }
        }
        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o1.getKey().compareTo(o2.getKey());
            else
                return o1.getValue().compareTo(o2.getValue());
        });

        hashMap.forEach((key,value)->priorityQueue.add(new Pair<>(key,value)));

        List<String> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.poll().getKey());
        }
        return ret;
    }

}
