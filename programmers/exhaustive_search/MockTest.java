package programmers.exhaustive_search;

import java.util.*;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] scores = {0, 0, 0};
        List<Integer> answer = new ArrayList<>();

        String mark1 = "12345".repeat(2000);
        String mark2 = "21232425".repeat(1250);
        String mark3 = "3311224455".repeat(1000);

        String s = "";
        for(int a : answers) {
            s += (a + "");
        }

        for(int i = 0; i < answers.length; i++) {
            if(mark1.charAt(i) == s.charAt(i))
                scores[0]++;
            if(mark2.charAt(i) == s.charAt(i))
                scores[1]++;
            if(mark3.charAt(i) == s.charAt(i))
                scores[2]++;
        }

        int max = scores[0];
        for(int i = 1; i < 2; i++) {
            if(max < scores[i]) max = scores[i];
        }

        for(int i = 0; i < 2; i++) {
            if(scores[i] == max)
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

}
