package dfs_bfs;

import java.util.*;

public class ConvertWord {
    static class Node {
        String word;
        int dist;

        Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }

    public int solution(String begin, String target, String[] words) {
        if(begin.length() != words[0].length()) return 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.word.equals(target))
                return current.dist;

            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;

                int count = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(current.word.charAt(j) != words[i].charAt(j))
                        count++;
                }

                if(count == 1) {
                    queue.add(new Node(words[i], current.dist + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }
}
