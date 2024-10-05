package implementation;

import java.io.*;

class SaveMoney {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long money = 0;
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if(input[0].equals("in")) {
                money += Long.parseLong(input[1]);
            } else {
                if(money < Long.parseLong(input[1])) {
                    System.out.println("fail");
                    return;
                }
                money -= Long.parseLong(input[1]);
            }
        }

        System.out.println("success");
    }
}
