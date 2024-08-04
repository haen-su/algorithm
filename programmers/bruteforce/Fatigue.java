package programmers.bruteforce;

import java.util.*;

public class Fatigue {
    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        for(int i = 0; i < dungeons.length; i++) {
            adventure(k, i, visited.clone(), dungeons);
        }
        return max;
    }

    public void adventure(int k, int idx, boolean[] visited, int[][] dungeons) {
        if(k < dungeons[idx][0] || k == 0) {
            int cnt = 0;
            for(boolean b : visited)
                if (b) cnt++;
            max = Math.max(max, cnt);
            return;
        }

        visited[idx] = true;
        int cnt = 0;

        for(boolean b : visited)
            if(b) cnt++;

        if(cnt == visited.length) {
            max = visited.length;
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                adventure(k - dungeons[idx][1], i, visited.clone(), dungeons);
            }
        }
    }
}
