package programmers.bruteforce;

import java.util.*;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {0, 0, 0};
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i % a.length]) scores[0]++;
            if(answers[i] == b[i % b.length]) scores[1]++;
            if(answers[i] == c[i % c.length]) scores[2]++;
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        for(int i = 0; i < 3; i++)
            if(scores[i] == max) answer.add(i + 1);

        int[] s = new int[answer.size()];
        int cnt = 0;
        for(int num : answer)
            s[cnt++] = num;
        return s;
    }

}
