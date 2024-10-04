package dfs_bfs;

import java.util.*;
import java.io.*;

public class Rumor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            String[] nodes = s.split(" ");
            graph[Integer.parseInt(nodes[0])][Integer.parseInt(nodes[1])] = graph[Integer.parseInt(nodes[1])][Integer.parseInt(nodes[0])] = 1;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        stack.push(1);

        while(!stack.empty()) {
            int current = stack.pop();
            if(visited[current]) continue;
            visited[current] = true;
            count++;

            for(int i = 1; i <= N; i++) {
                if(!visited[i] && graph[current][i] == 1)
                    stack.push(i);
            }
        }

        System.out.println(count);
    }
}