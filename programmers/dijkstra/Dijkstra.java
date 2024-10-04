package programmers.dijkstra;

import java.util.*;
import java.io.*;

public class Dijkstra {

    static class Node {
        int index, dist;
        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 100000;
            }
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[u][v] = graph[v][u] = cost;
        }

        int[] dist = new int[N];

        for(int i = 0; i < N; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
            boolean[] visited = new boolean[N];

            for(int j = 0; j < N; j++)
                dist[j] = 100000;
            dist[0] = 0;

            pq.add(new Node(0, 0));
            int answer = -1;

            while(!pq.isEmpty()) {
                Node current = pq.poll();
                if(current.index == i) {
                    answer = current.dist;
                    break;
                }

                if(visited[current.index]) continue;
                visited[current.index] = true;

                for(int j = 0; j < N; j++) {
                    if(dist[j] > dist[current.index] + graph[current.index][j]) {
                        dist[j] = dist[current.index] + graph[current.index][j];
                        pq.add(new Node(j, dist[j]));
                    }
                }
            }

            System.out.println(answer);
        }
    }
}

//6 9
//0 1 50
//0 2 30
//1 3 30
//1 4 70
//2 3 20
//2 4 40
//3 4 10
//3 5 80
//4 5 30
