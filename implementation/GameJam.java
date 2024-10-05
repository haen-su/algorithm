package implementation;

import java.io.*;

class GameJam {

    public static String[][] board;
    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int gr = Integer.parseInt(input[0]);
        int gc = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int pr = Integer.parseInt(input[0]);
        int pc = Integer.parseInt(input[1]);

        board = new String[N][N];

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                board[i][j] = input[j];
            }
        }

        int gs = game(gr - 1, gc - 1);
        int ps = game(pr - 1, pc - 1);

        if(gs > ps) {
            System.out.println("goorm " + gs);
        } else {
            System.out.println("player " + ps);
        }

    }

    public static int game(int r, int c) {

        boolean[][] visited = new boolean[N][N];
        boolean flag = true;
        int score = 1;
        visited[r][c] = true;

        while(flag) {

            String op = board[r][c];

            String command = op.charAt(op.length() - 1) + "";
            int count = Integer.parseInt(op.substring(0, op.length() - 1));

            if(command.equals("U")) {
                while(count --> 0) {
                    r--;
                    if(r == -1) r = N - 1;
                    if(visited[r][c]) {
                        flag = false;
                        break;
                    }
                    score++;
                    visited[r][c] = true;
                }
            } else if(command.equals("D")) {
                while(count --> 0) {
                    r++;
                    if(r == N) r = 0;
                    if(visited[r][c]) {
                        flag = false;
                        break;
                    }
                    score++;
                    visited[r][c] = true;
                }

            } else if(command.equals("L")) {
                while(count --> 0) {
                    c--;
                    if(c == -1) c = N - 1;
                    if(visited[r][c]) {
                        flag = false;
                        break;
                    }
                    score++;
                    visited[r][c] = true;
                }
            } else {
                while(count --> 0) {
                    c++;
                    if(c == N) c = 0;
                    if(visited[r][c]) {
                        flag = false;
                        break;
                    }
                    score++;
                    visited[r][c] = true;
                }
            }

        }

        return score;

    }
}
