package programmers.heap;

import java.util.*;

public class IndustrialSpy {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : ability)
            pq.offer(a);

        for(int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
        }

        int sum = 0;
        while(!pq.isEmpty())
            sum += pq.poll();

        return sum;

    }
}
