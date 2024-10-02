package programmers.implementation;
import java.util.*;

public class Hansu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }

    public static void solution(int N) {
        int count = 0;

        for(int i = 1; i <= N; i++) {
            if (Integer.toString(i).length() <= 2) {
                count++;
                continue;
            }

            if ((i % 10) - (i / 10 % 10) == (i / 10 % 10) - (i / 100))
                count++;
        }

        System.out.println(count);
    }
}
