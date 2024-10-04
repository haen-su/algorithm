package dfs_bfs;

import java.io.*;
import java.util.*;

class Generator2 {

    static class Node {
        int r, c, type;
        Node(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] M = new int[N][N];

        for(int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(s[j]);
            }
        }

        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[N][N];
        int[] complex = new int[31];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    stack.push(new Node(i, j, M[i][j]));
                    visited[i][j] = true;
                    int count = 0;
                    while(!stack.empty()) {
                        Node current = stack.pop();
                        int r = current.r;
                        int c = current.c;
                        int type = current.type;

                        count++;

                        if(r > 0 && !visited[r - 1][c] && M[r - 1][c] == type) {
                            stack.push(new Node(r - 1, c, type));
                            visited[r - 1][c] = true;
                        }

                        if(r < N - 1 && !visited[r + 1][c] && M[r + 1][c] == type) {
                            stack.push(new Node(r + 1, c, type));
                            visited[r + 1][c] = true;
                        }

                        if(c > 0 && !visited[r][c - 1] && M[r][c - 1] == type) {
                            stack.push(new Node(r, c - 1, type));
                            visited[r][c - 1] = true;
                        }

                        if(c < N -1 && !visited[r][c + 1] && M[r][c + 1] == type) {
                            stack.push(new Node(r, c + 1, type));
                            visited[r][c + 1] = true;
                        }
                    }

                    if(count >= K) {
                        complex[M[i][j]]++;
                    }
                }
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= 30; i++) {
            if(complex[i] >= max) {
                max = complex[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
