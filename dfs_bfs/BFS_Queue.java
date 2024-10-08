package dfs_bfs;
import java.util.*;

public class BFS_Queue {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        int[][] array = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 4},
                {3, 4}
        };
        N = 5;
        E = 6;

        for(int i = 0; i < array.length; i++)
            Graph[array[i][0]][array[i][1]] = Graph[array[i][1]][array[i][0]] = 1;

        solution();
    }

    public static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(0);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(visited[current]) continue;

            visited[current] = true;
            System.out.print(current + " ");

            for(int i = 0; i < N; i++)
                if(!visited[i] && Graph[current][i] == 1) queue.add(i);

        }
    }
}
