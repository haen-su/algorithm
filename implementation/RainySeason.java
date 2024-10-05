package implementation;

import java.io.*;
import java.util.*;

class RainySeason {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] h = new int[N + 1];
        input = br.readLine().split(" ");
        for(int i = 1; i <= N; i++)
            h[i] = Integer.parseInt(input[i - 1]);

        boolean[] visited = new boolean[N + 1];

        for(int i = 1; i <= M; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            for(int j = s; j <= e; j++) {
                h[j] += 1;
                visited[j] = true;
            }

            if(i % 3 == 0) {
                for(int j = 1; j <= N; j++)
                    if(visited[j]) h[j] -= 1;

                visited = new boolean[N + 1];
            }

        }

        for(int i = 1; i <= N - 1; i++)
            System.out.print(h[i] + " ");
        System.out.println(h[N]);
    }
}
