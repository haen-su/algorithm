package programmers.greedy;

import java.util.*;


public class Uniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] =-1;
                    answer++;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            if(lost[i] != -1) {
                for(int j = 0; j < reserve.length; j++) {
                    if(reserve[j] == lost[i] + 1 || reserve[j] == lost[i] - 1) {
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}