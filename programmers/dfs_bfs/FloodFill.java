package programmers.dfs_bfs;
import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        solution(1, 1, board);
    }

    public static void solution(int r, int c, int[][] board) {

        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        stack.push(new int[]{r, c});

        while(!stack.empty()) {
            int[] current = stack.pop();
            int cc = current[0];
            int cr = current[1];

            if(visited[cc][cr]) continue;

            visited[cc][cr] = true;
            board[cc][cr] = 3;

            if(cc > 0 && board[cc - 1][cr] != 1)
                stack.push(new int[]{cc - 1, cr});
            if(cc < board.length - 1 && board[cc + 1][cr] != 1)
                stack.push(new int[]{cc + 1, cr});
            if(cr > 0 && board[cc][cr - 1] != 1)
                stack.push(new int[]{cc, cr - 1});
            if(cr < board[0].length - 1 && board[cc][cr + 1] != 1)
                stack.push(new int[]{cc, cr + 1});
        }

    }

}
