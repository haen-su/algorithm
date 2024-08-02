package programmers.stackqueue;

import java.util.*;

public class DevelopFunction {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> deploys = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            deploys.add((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }

        int pre = deploys.poll();
        int cnt = 1;
        while(!deploys.isEmpty()) {
            if(pre >= deploys.peek()) {
                int deploy = pre;
                while(!deploys.isEmpty() && deploy >= deploys.peek()) {
                    pre = deploys.poll();
                    cnt++;
                }
            }
            else {
                answer.add(cnt);
                pre = deploys.poll();
                cnt = 1;
            }
        }

        answer.add(cnt);

        return answer;
    }
}


//99 1 99
