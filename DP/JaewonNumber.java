package DP;

import java.io.*;
import java.util.*;

class JaewonNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (long)Math.pow(3, i);
        }

        System.out.println(dp[n]);
    }
}
