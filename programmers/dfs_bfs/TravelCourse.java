package programmers.dfs_bfs;

import java.util.*;


class TravelCourse {

    boolean[] visited;
    List<String> answer = new ArrayList<>();

    public List<String> solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) return o2[1].compareTo(o1[1]);
                return o2[0].compareTo(o1[0]);
            }
        });

        List<String> course = new ArrayList<>();
        course.add("ICN");

        dfs("ICN", course, tickets);
        return answer;
    }

    public void dfs(String current, List<String> course, String[][] tickets) {
        if(course.size() == tickets.length + 1) {
            answer = course;
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && current.equals(tickets[i][0])) {
                visited[i] = true;
                List<String> tmp = new ArrayList<>(course);
                tmp.add(tickets[i][1]);
                dfs(tickets[i][1], tmp, tickets);
                visited[i] = false;
            }
        }
    }
}