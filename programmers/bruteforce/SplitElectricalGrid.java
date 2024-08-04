package programmers.bruteforce;

import java.util.*;


public class SplitElectricalGrid {
    public int solution(int n, int[][] wires) {
        int answer = 100;

        for(int i = 0; i < wires.length; i++) {
            HashSet<Integer> hs = new HashSet<>();
            hs.add(wires[i][0]);
            for(int j = 0; j < wires.length; j++) {
                for(int k = 0; k < wires.length; k++) {
                    if(i != k && (hs.contains(wires[k][0]) || hs.contains(wires[k][1]))) {
                        hs.add(wires[k][0]);
                        hs.add(wires[k][1]);
                    }
                }
            }

            answer = Math.min(answer, Math.abs((n - hs.size())- hs.size()));
        }

        return answer;
    }
}
