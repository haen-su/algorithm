package stackqueue;

import java.util.*;

class PairDelete {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            Character alpha = s.charAt(i);
            if(!stack.empty() && alpha == stack.peek()) {
                stack.pop();
            } else {
                stack.push(alpha);
            }
        }

        return (stack.empty()) ? 1 : 0;
    }
}