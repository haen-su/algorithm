package programmers.stackqueue;

import java.util.*;

public class CollectParens {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push("(");
            else {
                if(stack.empty()) return false;
                stack.pop();
            }

        }

        return stack.empty();
    }
}
