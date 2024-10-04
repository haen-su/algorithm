package dfs_bfs;
import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(solution(0, 1, 4, 2, board));
    }

    static class Point {
        int row, col, dist;
        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int solution(int s_r, int s_c, int d_r, int d_c, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        queue.add(new Point(s_r, s_c, 0));

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int c_r = current.row;
            int c_c = current.col;

            if(c_r == d_r && c_c == d_c)
                return current.dist;

            if(visited[c_r][c_c])
                continue;

            visited[c_r][c_c] = true;

            if(c_r > 0 && board[c_r - 1][c_c] != 1)
                queue.add(new Point(c_r - 1, c_c, current.dist + 1));
            if(c_r < board.length - 1 && board[c_r + 1][c_c] != 1)
                queue.add(new Point(c_r + 1, c_c, current.dist + 1));
            if(c_c > 0 && board[c_r][c_c - 1] != 1)
                queue.add(new Point(c_r, c_c - 1, current.dist + 1));
            if(c_c < board[0].length - 1 && board[c_r][c_c + 1] != 1)
                queue.add(new Point(c_r, c_c + 1, current.dist + 1));
        }

        return -1;
    }
}
