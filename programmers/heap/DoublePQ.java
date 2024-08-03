package programmers.heap;

import java.util.*;

public class DoublePQ {
    public int[] solution(String[] operations) {
        Queue<String> op = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            op.offer(operation.substring(0, 1));
            num.offer(Integer.parseInt(operation.substring(2)));
        }

        while(!op.isEmpty()) {
            if(op.poll().equals("I")) {
                minPQ.offer(num.peek());
                maxPQ.offer(num.poll());
            } else {
                if(num.poll().equals(1)) {
                    if(!maxPQ.isEmpty()) {
                        minPQ.remove(maxPQ.poll());
                    }
                } else {
                    if(!minPQ.isEmpty()) {
                        maxPQ.remove(minPQ.poll());
                    }
                }
            }
        }

        if(minPQ.isEmpty()) return new int[]{0, 0};
        else
           return new int[]{maxPQ.poll(), minPQ.poll()};
    }

}
