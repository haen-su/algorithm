package dfs_bfs;

import java.io.*;
import java.util.*;

public class Generator {
    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] M = new int[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sa = s.split(" ");

            for(int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(sa[j]);
            }
        }

        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(M[i][j] == 1 && !visited[i][j]) {
                    stack.push(new Node(i, j));

                    while(!stack.empty()) {
                        Node current = stack.pop();
                        visited[current.r][current.c] = true;

                        if(current.r > 0 && M[current.r - 1][current.c] == 1 && !visited[current.r - 1][current.c])
                            stack.push(new Node(current.r - 1, current.c));

                        if(current.r < N - 1 && M[current.r + 1][current.c] == 1 && !visited[current.r + 1][current.c])
                            stack.push(new Node(current.r + 1, current.c));

                        if(current.c > 0 && M[current.r][current.c - 1] == 1 && !visited[current.r][current.c - 1])
                            stack.push(new Node(current.r, current.c - 1));

                        if(current.c < N - 1 && M[current.r][current.c + 1] == 1 && !visited[current.r][current.c + 1])
                            stack.push(new Node(current.r, current.c + 1));
                    }

                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
