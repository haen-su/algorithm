package dfs_bfs;

import java.util.*;

public class GameMapShortestPath {
    class Point {
        int row, col, dist;
        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int c_r = current.row;
            int c_c = current.col;

            if(c_r == maps.length - 1 && c_c == maps[0].length - 1)
                return current.dist;


            if(c_r > 0 && maps[c_r - 1][c_c] == 1 && !visited[c_r - 1][c_c]) {
                visited[c_r - 1][c_c] = true;
                queue.add(new Point(c_r - 1, c_c, current.dist + 1));
            }

            if(c_r < maps.length - 1 && maps[c_r + 1][c_c] == 1 && !visited[c_r + 1][c_c]) {
                visited[c_r + 1][c_c] = true;
                queue.add(new Point(c_r + 1, c_c, current.dist + 1));
            }


            if(c_c > 0 && maps[c_r][c_c - 1] == 1 && !visited[c_r][c_c - 1]) {
                visited[c_r][c_c - 1] = true;
                queue.add(new Point(c_r, c_c - 1, current.dist + 1));
            }

            if(c_c < maps[0].length - 1 && maps[c_r][c_c + 1] == 1 && !visited[c_r][c_c + 1]) {
                visited[c_r][c_c + 1] = true;
                queue.add(new Point(c_r, c_c + 1, current.dist + 1));
            }

        }

        return -1;
    }
}
