package stackqueue;

import java.util.*;

public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue p = new PriorityQueue<>(Collections.reverseOrder());;

        for(int i=0; i<priorities.length; i++){
            p.add(priorities[i]);
            System.out.println(p);
        }
        System.out.println(p);

        while(!p.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)p.peek()){
                    if(i == location){
                        return answer;
                    }
                    p.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
    
}