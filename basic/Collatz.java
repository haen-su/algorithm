package basic;

class Collatz {
    public int solution(int num) {
        int answer = 0;
        int i = 1;
        long n = num;

        while(n != 1 && i <= 500) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            answer++;
            i++;
        }

        if(n == 1) return answer;
        else return -1;
    }
}
