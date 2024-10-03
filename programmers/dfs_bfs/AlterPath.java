package programmers.dfs_bfs;
import java.io.*;
import java.util.*;

class AlterPath {

    static class Node {
        int index, dist;
        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int S = Integer.parseInt(s[2]);
        int E = Integer.parseInt(s[3]);

        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            hm.putIfAbsent(Integer.parseInt(s[0]), new ArrayList<>());
            hm.putIfAbsent(Integer.parseInt(s[1]), new ArrayList<>());

            hm.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            hm.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }


        StringBuilder sb = new StringBuilder();
        for(int day = 1; day <= N; day++) {
            if(day == S || day == E) {
                System.out.println(-1);
                continue;
            }

            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            visited = new boolean[N + 1];
            queue.add(new Node(S, 1));
            visited[S] = true;
            int answer = -1;

            while(!queue.isEmpty()) {
                Node current = queue.poll();

                if(current.index == E) {
                    answer = current.dist;
                    break;
                }

                for(Integer i : hm.get(current.index)) {
                    if(i != day && !visited[i]) {
                        queue.add(new Node(i, current.dist + 1));
                        visited[i] = true;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
