package implementation;

import java.io.*;

class SumCalculator {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[2]);

            if(input[1].equals("+"))
                sum += (x + y);
            else if(input[1].equals("-"))
                sum += (x - y);
            else if(input[1].equals("*"))
                sum += (x * y);
            else
                sum += (x / y);
        }

        System.out.println(sum);
    }
}
