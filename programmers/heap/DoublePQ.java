package programmers.heap;

import java.util.*;

public class DoublePQ {
    public int[] solution(String[] operations) {
        Queue<String> op = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            op.offer(operation.substring(0, 1));
            num.offer(Integer.parseInt(operation.substring(2)));
        }

        while(!op.isEmpty()) {
            if(op.poll().equals("I")) {
                queue.offer(num.poll());
            } else {
                if(num.poll().equals(1)) {
                    if(!queue.isEmpty()) {
                        while(!queue.isEmpty()) {
                            maxPQ.offer(queue.poll());
                        }
                        maxPQ.poll();
                        while(!maxPQ.isEmpty())
                            queue.offer(maxPQ.poll());
                    }
                } else {
                    if(!queue.isEmpty()) {
                        while(!queue.isEmpty()) {
                            minPQ.offer(queue.poll());
                        }
                        minPQ.poll();
                        while(!minPQ.isEmpty())
                            queue.offer(minPQ.poll());
                    }
                }
            }
        }

        if(queue.isEmpty()) return new int[]{0, 0};
        else {
           while(!queue.isEmpty()) {
               int poll = queue.poll();
               maxPQ.offer(poll);
               minPQ.offer(poll);
           }
           return new int[]{maxPQ.poll(), minPQ.poll()};
        }
    }

}
