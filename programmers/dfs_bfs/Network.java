package programmers.dfs_bfs;

import java.util.*;
public class Network {
    static public boolean[] visited;
    static public Queue<Integer> q = new LinkedList<>();
    static public int cnt = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                q.offer(i);
                visited[i] = true;
                bfs(computers);
                cnt++;
            }
        }
        return cnt;
    }

    public void bfs(int[][] computers) {
        while(!q.isEmpty()) {
            int computer = q.poll();
            for(int i =  0; i < computers.length; i++) {
                if(!visited[i] && computers[computer][i] == 1) {
                    visited[i] = true;
                    System.out.println(i);
                    q.offer(i);
                }
            }
        }
    }
}
