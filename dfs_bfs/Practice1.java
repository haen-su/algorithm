package dfs_bfs;
import java.io.*;
import java.util.*;

public class Practice1 {

    static class Node {
        int index, dist;
        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int T = Integer.parseInt(input[2]);
        int S = Integer.parseInt(input[3]);
        int E = Integer.parseInt(input[4]);

        int[] fp = new int[T];
        input = br.readLine().split(" ");
        for(int i = 0; i < T; i++)
            fp[i] = Integer.parseInt(input[i]);

        HashMap<Integer, List<Integer>> hm1 = new HashMap<>(); // 단방향 간선
        HashMap<Integer, List<Integer>> hm2 = new HashMap<>(); // 양방향 간선

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            hm1.putIfAbsent(u, new ArrayList<>());
            hm1.get(u).add(v);

            hm2.putIfAbsent(u, new ArrayList<>());
            hm2.get(u).add(v);
            hm2.putIfAbsent(v, new ArrayList<>());
            hm2.get(v).add(u);
        }

        int min = Integer.MAX_VALUE;
        int buy = -1;

        for(int t = 0; t < T; t++) {
            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            queue.add(new Node(S, 0));
            visited[S] = true;
            int freepass = -1;  // 프리패스 산 거리

            while(!queue.isEmpty()) {
                Node current = queue.poll();
                int u = current.index;

                if(u == fp[t]) {
                    freepass = current.dist;
                    break;
                }

                if(hm1.get(u) == null) continue;
                for(int v : hm1.get(u)) {
                    if(!visited[v]) {
                        queue.add(new Node(v, current.dist + 1));
                        visited[v] = true;
                    }
                }
            }

            if(freepass == -1) continue;

            queue = new LinkedList<>();
            visited = new boolean[N + 1];

            queue.add(new Node(fp[t], 0));
            visited[fp[t]] = true;

            while(!queue.isEmpty()) {
                Node current = queue.poll();
                int u = current.index;

                if(u == E) {
                    if(min > freepass + current.dist) {
                        min = freepass + current.dist;
                        buy = fp[t];
                        break;
                    } else if(min == freepass + current.dist) {
                        buy = Math.min(buy, fp[t]);
                        break;
                    }
                }

                if(hm2.get(u) == null) continue;
                for(int v : hm2.get(u)) {
                    if(!visited[v]) {
                        queue.add(new Node(v, current.dist + 1));
                        visited[v] = true;
                    }
                }
            }
        }

        System.out.print(buy);
        if(buy == -1) return;
        System.out.println(" " + min);
    }
}
