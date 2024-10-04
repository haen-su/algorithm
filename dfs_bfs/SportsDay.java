package dfs_bfs;

public class SportsDay {
    int max = 0;
    boolean[] visited;

    public int solution(int[][] ability) {
        int answer = 0;
        visited = new boolean[ability.length];

        dfs(ability, 0, 0);

        return max;
    }

    public void dfs(int[][] ability, int sum, int c) {
        if(c == ability[0].length) {
            max = Math.max(max, sum);
            return;
        }
        for(int r = 0; r < ability.length; r++) {
            if(!visited[r]) {
                visited[r] = true;
                dfs(ability, sum + ability[r][c], c + 1);
                visited[r] = false;
            }
        }
    }
}
