package string;

import java.util.*;

class BinaryConvert {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            String tmp = s;

            s = s.replace("0", "");
            answer[1] += tmp.length() - s.length();

            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }

        return answer;
    }
}
