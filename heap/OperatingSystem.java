package heap;

import java.util.*;

public class OperatingSystem {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        // 호출시간 우선순위 큐
        PriorityQueue<int[]> q1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 점수 우선순위 큐
        PriorityQueue<int[]> q2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < program.length; i++)
            q1.offer(program[i]);

        int time = 0;
        while(!q1.isEmpty() || !q2.isEmpty()) {
            while(!q1.isEmpty() && q1.peek()[1] <= time) {
                q2.offer(q1.poll());
            }
            if(q2.isEmpty()) {
                time = q1.peek()[1];
            } else {
                int[] p = q2.poll();
                answer[p[0]] += time - p[1];
                time += p[2];
            }
        }

        answer[0] = time;
        // 프로그램 종료 시각 + 프로그램 점수가 i인 프로그램들의 대기시간 합
        return answer;
    }
}
