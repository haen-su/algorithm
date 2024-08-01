package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

    public String solution(int[] numbers) {

        String answer = "";

        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = numbers[i] + "";
        }

        Arrays.sort(stringNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        for(String stringNumber : stringNumbers)
            answer += stringNumber;

        if(answer.charAt(0) == '0')
            answer = "0";

        return answer;
    }

}

