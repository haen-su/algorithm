package programmers.dfs_bfs;

import java.io.*;
import java.util.*;

class WorldTour {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] languages = new int[N + 1];

        for(int i = 1; i <= N; i++)
            languages[i] = Integer.parseInt(input[i - 1]);

        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            hm.putIfAbsent(Integer.parseInt(input[0]), new ArrayList<>());
            hm.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            hm.putIfAbsent(Integer.parseInt(input[1]), new ArrayList<>());
            hm.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        int max = 1;

        for(int language = 1; language <= 10; language++) {
            if(language == languages[1]) continue;

            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[N + 1];

            int count = 0;
            stack.push(1);

            while(!stack.empty()) {
                int current = stack.pop();
                if(visited[current]) continue;

                visited[current] = true;
                count++;

                if(hm.get(current) != null) {
                    for(int next : hm.get(current)) {
                        if(!visited[next] && (languages[next] == languages[1] || languages[next] == language))
                            stack.push(next);
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);

    }
}
