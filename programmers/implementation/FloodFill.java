package programmers.implementation;

public class FloodFill {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0},
                         {0, 0, 0, 1, 1},
                         {0, 0, 0, 1, 0},
                         {1, 1, 1, 1, 0},
                         {0, 0, 0, 0, 0}
                        };
        solution(1, 1, board);

    }

    public static void solution(int r, int c, int[][] board) {
        if(r < 0 || r > board[0].length - 1 || c < 0 || c > board[0].length - 1)
            return;

        if(board[r][c] == 1)
            return;

        board[r][c] = 1;

        solution(r - 1, c, board);
        solution(r + 1, c, board);
        solution(r, c - 1, board);
        solution(r, c + 1, board);
    }
}
