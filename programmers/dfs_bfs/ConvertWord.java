package programmers.dfs_bfs;

import java.util.*;

public class ConvertWord {
    int[] visited;
    Queue<Integer> q = new LinkedList<>();
    int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new int[words.length + 1];
        String[] tmp = new String[words.length + 1];
        tmp[0] = begin;

        for(int i = 0; i < words.length; i++)
            tmp[i + 1] = words[i];

        q.add(0);
        visited[0] = 0;
        bfs(tmp, target);
        return answer;
    }

    public void bfs(String[] words, String target) {
        while(!q.isEmpty()) {
            String word = words[q.peek()];
            int idx = q.poll();

            if(word.equals(target)) {
                answer = visited[idx];
                return;
            }

            for(int i = 0; i < words.length; i++) {
                if(visited[i] == 0) {
                    int cnt = 0;
                    for(int j = 0; j < word.length(); j++) {
                        if(word.charAt(j) == words[i].charAt(j)) cnt++;
                    }
                    if(cnt == word.length() - 1) {
                        q.add(i);
                        visited[i] = visited[idx] + 1;
                    }
                }
            }
        }
    }
}
