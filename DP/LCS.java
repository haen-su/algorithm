package DP;

import java.io.*;

public class LCS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(lcs(s1, s2));
    }

    public static int lcs(String s1, String s2) {
        int x = s1.length();
        int y = s2.length();

        if(x == 0 || y == 0)
            return 0;

        if(s1.charAt(x - 1) == s2.charAt(y - 1))
            return lcs(s1.substring(0, x - 1), s2.substring(0, y - 1)) + 1;
        else {
            return Math.max(lcs(s1.substring(0, x), s2.substring(0, y - 1)),
                    lcs(s1.substring(0, x - 1), s2.substring(0, y)));
        }

    }
}
