package programmers.dfs_bfs;
import java.util.*;

public class DFS_Stack {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    static boolean[] Visited = new boolean[MAX_N];

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

        solution(array);
    }

    public static void solution(int[][] array) {
        for(int i = 0; i < array.length; i++)
            Graph[array[i][0]][array[i][1]] = Graph[array[i][1]][array[i][0]] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.empty()) {
            int current = stack.pop();
            if(Visited[current]) continue;

            System.out.print(current + " ");
            Visited[current] = true;

            for(int i = 0; i < N; i++) {
                if(!Visited[i] && Graph[current][i] != 0)
                    stack.push(i);
            }
        }
    }

}
