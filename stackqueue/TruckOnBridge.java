package stackqueue;

import java.util.*;


public class TruckOnBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for(int truck_weight : truck_weights)
            trucks.add(truck_weight);

        int time = 0;
        int currentWeight = 0;
        while(true) {
            if(trucks.isEmpty()) {
                time += bridge_length;
                break;
            }
            if(currentWeight + trucks.peek() <= weight) {
                int poll = trucks.poll();
                bridge.add(poll);
                currentWeight += poll;
                time++;
                System.out.println("현재 다리: " + bridge);
                System.out.println("현재 무게: " + currentWeight);
                System.out.println("경과 시간: " + time);
            }
            else {
                bridge.add(0);
                time++;
                System.out.println("현재 다리: " + bridge);
                System.out.println("현재 무게: " + currentWeight);
                System.out.println("경과 시간: " + time);
            }
            if(bridge.size() == bridge_length) {
                currentWeight -= bridge.poll();
            }
        }

        return time;
    }
}
