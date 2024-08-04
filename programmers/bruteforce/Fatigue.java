package programmers.bruteforce;

import java.util.*;

public class Fatigue {
    static int max = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return max;
    }

    public void dfs(int k, int cnt, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }

            max = Math.max(max, cnt);
        }
    }
}
