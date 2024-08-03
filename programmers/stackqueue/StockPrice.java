package programmers.stackqueue;

import java.util.*;


public class StockPrice {
    public List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for(int j = i + 1; j < prices.length; j++) {
                cnt++;
                if(prices[i] > prices[j]) break;
            }
            answer.add(cnt);
        }

        return answer;
    }
}
