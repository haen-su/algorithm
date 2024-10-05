package DP;

import java.io.*;

public class LIS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        dp[0] = 1;

        for(int i = 1; i < N; i++) {
            dp[i] = 1;
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i] && dp[j] > max) {
                    max = dp[j];
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int d : dp) {
            answer = Math.max(d, answer);
        }

        System.out.println(answer);
    }

}
