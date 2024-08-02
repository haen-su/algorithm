package programmers.stackqueue;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            q.offer(new int[]{i, priorities[i]});
        }

        int priority = pq.poll();
        while(!pq.isEmpty()) {
            while(!q.isEmpty()) {
                int[] poll = q.poll();
                if(poll[1] == priority) {
                    answer++;
                    if(!pq.isEmpty()) priority = pq.poll();
                    if(poll[0] == location) return answer;
                } else {
                    q.offer(poll);
                }
            }
        }

        return answer;
    }
    
}

// 1234
// 4123