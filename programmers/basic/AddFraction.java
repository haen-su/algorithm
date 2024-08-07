package programmers.basic;

public class AddFraction {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        int d = Math.min(numer, denom);
        while(d != 1) {
            if(numer % d == 0 && denom % d == 0) {
                numer /= d;
                denom /= d;
            }
            d--;
        }

        return new int[]{numer, denom};
    }
}
