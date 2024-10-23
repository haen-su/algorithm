package string;

import java.util.*;

class JadenCase {
    public String solution(String s) {
        s = s.toLowerCase();
        Queue<String> queue = new LinkedList<>();
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            String c = Character.toString(s.charAt(i));
            if(c.equals(" ")) {
                String word = "";
                boolean flag = true;
                while(!queue.isEmpty()) {
                    if(flag) {
                        word += queue.poll().toUpperCase();
                        flag = false;
                    } else {
                        word += queue.poll();
                    }
                }
                answer += word + " ";
            } else {
                queue.add(c);
            }
        }

        String word = "";
        boolean flag = true;
        while(!queue.isEmpty()) {
            if(flag) {
                word += queue.poll().toUpperCase();
                flag = false;
            } else {
                word += queue.poll();
            }
        }

        return answer + word;

    }
}