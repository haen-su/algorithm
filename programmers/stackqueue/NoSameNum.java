package programmers.stackqueue;

import java.util.*;

public class NoSameNum {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[arr.length - 1]);

        for(int i = arr.length - 1; i >= 0 ; i--) {
            if(stack.peek() != arr[i])
                stack.add(arr[i]);
        }

        int cnt = stack.size();
        int[] answer = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
