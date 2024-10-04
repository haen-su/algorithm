package programmers.implementation;

import java.io.*;
import java.util.*;

class UpDown {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] p = new int[N];

        for(int i = 0; i < N; i++)
            p[i] = Integer.parseInt(input[i]);

        Arrays.sort(p);
        int start = 0;
        int end = N - 1;

        for(int i = 0; i < K; i++) {
            input = br.readLine().split(" ");

            if(input[1].equals("1")) {
                for(int j = start; j < N; j++) {
                    if(p[j] <= Integer.parseInt(input[0]))
                        start++;
                    else break;
                }
            } else {
                for(int j = end; j >= 0; j--) {
                    if(p[j] >= Integer.parseInt(input[0]))
                        end--;
                    else break;
                }
            }

            if(start > end) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(end - start + 1);

    }
}
