package dfs_bfs;

import java.util.*;

public class OilDrilling {
    public int solution(int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] answer = new int[land[0].length];

        for (int c = 0; c < land[0].length; c++) {
            for (int r = 0; r < land.length; r++) {
                if (!visited[r][c] && land[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                    boolean[] vc = new boolean[land[0].length];
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int i = p[0];
                        int j = p[1];
                        vc[j] = true;
                        cnt++;

                        if (p[0] < land.length - 1 && !visited[i + 1][j] && land[i + 1][j] == 1) {
                            q.offer(new int[]{i + 1, j});
                            visited[i + 1][j] = true;
                        }
                        if (p[1] < land[0].length - 1 && !visited[i][j + 1] && land[i][j + 1] == 1) {
                            q.offer(new int[]{i, j + 1});
                            visited[i][j + 1] = true;
                        }
                        if (p[0] > 0 && !visited[i - 1][j] && land[i - 1][j] == 1) {
                            q.offer(new int[]{i - 1, j});
                            visited[i - 1][j] = true;
                        }
                        if (p[1] > 0 && !visited[i][j - 1] && land[i][j - 1] == 1) {
                            q.offer(new int[]{i, j - 1});
                            visited[i][j - 1] = true;
                        }
                    }
                    for (int i = 0; i < vc.length; i++) {
                        if (vc[i]) answer[i] += cnt;
                    }
                }
            }
        }

        int max = 0;
        for(int a : answer) {
            max = Math.max(max, a);
        }
        return max;
    }
}
