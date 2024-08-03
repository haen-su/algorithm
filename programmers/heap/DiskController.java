package programmers.heap;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        // 소요 시간 우선순위 큐
        PriorityQueue<int[]> queue1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        // 요청 시간 우선순위 큐
        PriorityQueue<int[]> queue2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int[] job : jobs)
            queue2.offer(job);

        int sum = 0;
        int time = 0;
        while(!queue2.isEmpty() || !queue1.isEmpty()) {
            while(!queue2.isEmpty() && queue2.peek()[0] <= time)
                queue1.offer(queue2.poll());

            if(queue1.isEmpty())
                time = queue2.peek()[0];
            else {
                int[] poll = queue1.poll();
                sum += time + poll[1] - poll[0];
                time += poll[1];
            }
        }

        return sum / jobs.length;
    }
}
