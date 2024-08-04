package programmers.bruteforce;

public class FindPrimeNumber {

    static int cnt = 0;
    static boolean[] visited;
    static boolean[] concat;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        concat = new boolean[10000000];
        concat[0] = true;

        dfs(0, numbers);

       return cnt;
    }

    public void dfs(int n, String numbers) {
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                int num = n * 10 + (numbers.charAt(i) - '0');
                if(concat[num]) continue;
                concat[num] = true;
                System.out.println(num);
                if(isPrime(num)) cnt++;

                visited[i] = true;
                dfs(num, numbers);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if(num == 1) return false;
        if(num == 2) return true;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
