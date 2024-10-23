package basic;

import java.util.*;

class XandN {
    public List<Long> solution(int x, int n) {

        List<Long> answer = new ArrayList<>();

        long l = x;
        for(int i = 0; i < n; i++) {
            answer.add(l);
            l += x;
        }

        return answer;
    }
}
