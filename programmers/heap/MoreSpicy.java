package programmers.heap;

import java.util.*;


public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville) pq.offer(s);

        int cnt = 0;
        while(true) {
            int poll = pq.poll();

            if(poll >= K) {
                answer = cnt;
                break;
            }

            pq.offer(poll + pq.poll() * 2);
            cnt++;

            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
