package implementation;

import java.io.*;

class BrokenComputer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] T = new int[N];
        for(int i = 0; i < N; i++)
            T[i] = Integer.parseInt(input[i]);

        int removeTime = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(T[i] >= removeTime) count = 0;
            count++;
            removeTime = T[i] + c + 1;
        }

        System.out.println(count);
    }
}
