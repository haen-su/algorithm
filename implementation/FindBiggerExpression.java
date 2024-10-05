package implementation;

import java.io.*;
import java.util.*;

class FindBiggerExpression {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long[] results = new long[2];

        for(int i = 0; i < 2; i++) {
            Deque<String> queue = new ArrayDeque<>();
            String[] nums = input[i].split("[*]|[+]|[-]");

            queue.addLast(nums[0]);
            int index = 1;

            for(int j = 0; j < input[i].length(); j++) {
                char c = input[i].charAt(j);
                if(c == '+' || c == '-') {
                    queue.addLast(c + "");
                    queue.addLast(nums[index]);
                    index++;
                } else if(c == '*') {
                    long num1 = Long.parseLong(queue.pollLast());
                    long num2 = Long.parseLong(nums[index]);
                    queue.addLast(Long.toString(num1 * num2));
                    index++;
                }
            }

            long num = Long.parseLong(queue.pollFirst());

            while(!queue.isEmpty()) {
                String op = queue.pollFirst();
                if(op.equals("+")) {
                    num = num + Long.parseLong(queue.pollFirst());
                } else {
                    num = num - Long.parseLong(queue.pollFirst());
                }
            }

            results[i] = num;

        }

        System.out.println(Math.max(results[0], results[1]));
    }
}
