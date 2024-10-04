package DP;

import java.io.*;

public class RangeSum4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] numbers = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++)
            dp[i] += dp[i - 1] + numbers[i - 1];

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int b = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]);

            System.out.println(dp[e] - dp[b]);
        }
    }
}
