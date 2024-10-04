package dijkstra;

import java.util.*;

class Delivery {

    class Node {
        int index, dist;
        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 1000000;
            }
        }

        for(int i = 0; i< road.length; i++) {
            graph[road[i][0]][road[i][1]] = graph[road[i][1]][road[i][0]]
                    = Math.min(road[i][2], graph[road[i][0]][road[i][1]]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(1, 0));

        int[] dist = new int[N + 1];
        for(int i = 1; i <= N; i++)
            dist[i] = 1000000;
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.index;

            if(visited[u]) continue;
            visited[u] = true;

            for(int v = 1; v <= N; v++) {
                if(dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                count++;
            }
        }

        return count;
    }
}
