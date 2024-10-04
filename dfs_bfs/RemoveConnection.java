package dfs_bfs;

import java.io.*;
import java.util.*;

class RemoveConnection {

    static class Node {
        int r, c;
        String alpha;
        Node(int r, int c, String alpha) {
            this.r = r;
            this.c = c;
            this.alpha = alpha;
        }
    }

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        String[][] board = new String[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j) + "";
            }
        }

        for(int q = 0; q < Q; q++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;
            board[r][c] = input[2];

            Stack<Node> stack = new Stack<>();
            boolean[][] visited = new boolean[N][N];
            List<int[]> removes = new ArrayList<>();

            stack.push(new Node(r, c, board[r][c]));

            while(!stack.empty()) {
                Node current = stack.pop();
                int cr = current.r;
                int cc = current.c;

                if(!visited[cr][cc]) removes.add(new int[]{cr, cc});
                visited[cr][cc] = true;

                for(int d = 0; d < 4; d++) {
                    int nr = cr - dr[d];
                    int nc = cc - dc[d];

                    if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc].equals(current.alpha)) {
                        stack.push(new Node(nr, nc, current.alpha));
                    }
                }
            }

            if(removes.size() >= K) {
                for(int[] remove : removes) {
                    board[remove[0]][remove[1]] = ".";
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                bw.write(board[i][j]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}