package programmers.dfs_bfs;

import java.util.*;

public class GameMapShortestPath {
    int[][] visited;
    Queue<int[]> q = new LinkedList<>();

    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        q.offer(new int[]{0, 0});
        return dfs(maps);
    }

    public int dfs(int[][] maps) {
        while(!q.isEmpty()) {
            int[] here = q.poll();
            int r = here[0];
            int c = here[1];

            if(r == maps.length - 1 && c == maps[0].length - 1)
                return visited[maps.length - 1][maps[0].length - 1];

            if(r < maps.length - 1 && visited[r + 1][c] == 0 && maps[r + 1][c] == 1) {
                q.offer(new int[]{r + 1, c});
                visited[r + 1][c] += visited[r][c] + 1;
            }
            if(c < maps[0].length - 1 && visited[r][c + 1] == 0 && maps[r][c + 1] == 1) {
                q.offer(new int[]{r, c + 1});
                visited[r][c + 1] = visited[r][c] + 1;
            }
            if(r > 0 && visited[r - 1][c] == 0 && maps[r - 1][c] == 1) {
                q.offer(new int[]{r - 1, c});
                visited[r - 1][c] = visited[r][c] + 1;
            }
            if(c > 0 && visited[r][c - 1] == 0 && maps[r][c - 1] == 1) {
                q.offer(new int[]{r, c - 1});
                visited[r][c - 1] = visited[r][c] + 1;
            }
        }

        return -1;
    }
}
