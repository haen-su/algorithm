package sort;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int h = 0; h <= 10000; h++) {
            for(int n = 0; n < citations.length; n++) {
                if ((citations[n] >= h) && (citations.length - n >= h)
                        && (n <= h) && (answer < h))
                    answer = h;
            }
        }

        return answer;
    }
}
