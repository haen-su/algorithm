package dfs_bfs;

import java.io.*;
import java.util.*;

class Union {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            graph[S][E] = 1;
        }

        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int current = queue.poll();

                    for(int j = 1; j <= N; j++) {
                        if(!visited[j] && graph[current][j] == 1 && graph[j][current] == 1) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
                count++;
            }
        }

        System.out.println(count);
    }
}
