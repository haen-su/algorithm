package basic;

import java.util.*;

class DeleteMinValue {
    public List<Integer> solution(int[] arr) {

        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(i != index) {
                answer.add(arr[i]);
            }
        }

        if(answer.size() == 0) {
            answer.add(-1);
        }

        return answer;

    }
}
