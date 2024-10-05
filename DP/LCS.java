package DP;

import java.io.*;

public class LCS {
    static public Integer[][] dp;
    static public String s1;
    static public String s2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new Integer[s1.length() + 1][s2.length() + 1];
        System.out.println(lcs(s1.length(), s2.length()));
    }

    public static int lcs(int x, int y) {
        if(x == 0 || y == 0)
            return 0;

        if(dp[x][y] == null) {
            dp[x][y] = 0;

            if(s1.charAt(x - 1) == s2.charAt(y - 1))
                dp[x][y] = lcs(x - 1, y - 1) + 1;
            else {
                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
