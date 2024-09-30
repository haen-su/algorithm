package programmers.dfs_bfs;

public class DFS_Recursive {
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

        dfs(0);
    }

    public static void dfs(int node) {
        Visited[node] = true;
        System.out.print(node + " ");

        for(int i = 0; i < N; i++) {
            if(!Visited[i] && Graph[node][i] != 0)
                dfs(i);
        }
    }
}
