package dfs_bfs;

import java.io.*;
import java.util.*;

class FindPlanet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<Integer, List<Integer>> smaller = new HashMap<>();
        HashMap<Integer, List<Integer>> bigger = new HashMap<>();

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            smaller.putIfAbsent(Integer.parseInt(input[0]), new ArrayList<>());
            smaller.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));

            bigger.putIfAbsent(Integer.parseInt(input[1]), new ArrayList<>());
            bigger.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        for(int i = 1; i <= N; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[N + 1];
            stack.push(i);
            int count = -1;

            while(!stack.empty()) {
                int current = stack.pop();
                if(!visited[current]) count++;
                visited[current] = true;

                if(bigger.get(current) == null) continue;
                for(int next : bigger.get(current)) {
                    if(!visited[next])
                        stack.push(next);
                }
            }

            System.out.print(count + " ");

            visited = new boolean[N + 1];
            stack.push(i);
            count = -1;

            while(!stack.empty()) {
                int current = stack.pop();
                if(!visited[current]) count++;
                visited[current] = true;

                if(smaller.get(current) == null) continue;
                for(int next : smaller.get(current)) {
                    if(!visited[next])
                        stack.push(next);
                }
            }

            System.out.println(count);

        }
    }
}
