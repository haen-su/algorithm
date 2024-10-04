package dfs_bfs;

import java.util.*;
public class Network {
    public int solution(int n, int[][] computers) {
        int[][] graph = new int[n][n];
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 || i == j)
                    graph[i][j] = graph[j][i] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            stack.push(i);

            while(!stack.empty()) {
                int current = stack.pop();

                visited[current] = true;

                for(int j = 0; j < n; j++) {
                    if(j != current && graph[current][j] == 1 && !visited[j])
                        stack.push(j);
                }

            }

            count++;
        }

        return count;
    }
}
