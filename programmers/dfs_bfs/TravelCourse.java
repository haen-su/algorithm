package programmers.dfs_bfs;

import java.util.*;


class TravelCourse {

    boolean[] visited;
    List<List<String>> answer = new ArrayList<>();

    public List<String> solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if(s1[0].equals(s2[0])) return s1[1].compareTo(s2[1]);
                return s1[0].compareTo(s2[0]);
            }
        });

        List<String> sequence;
        for(int r = 0; r < tickets.length; r++) {
            if(tickets[r][0].equals("ICN")) {
                sequence = new ArrayList<>();
                sequence.add(tickets[r][0]);
                sequence.add(tickets[r][1]);

                visited[r] = true;
                dfs(tickets, sequence);
                visited[r] = false;
            }
        }

        return answer.get(0);
    }

    public void dfs(String[][] tickets, List<String> sequence) {
        boolean finish = true;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                finish = false;
            }
        }
        if(finish) {
            answer.add(sequence);
        }

        for(int r = 0; r < tickets.length; r++) {
            if(!visited[r] && tickets[r][0].equals(sequence.get(sequence.size() - 1))) {
                List<String> tmp = new ArrayList<>();
                tmp.addAll(sequence);
                tmp.add(tickets[r][1]);

                visited[r] = true;
                dfs(tickets, tmp);
                visited[r] = false;
            }
        }
    }
}