package implementation;

public class HarshadNumber {
    public boolean solution(int x) {
        String s = Integer.toString(x);
        String[] a = s.split("");

        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += Integer.parseInt(a[i]);
        }

        if(x % sum == 0) return true;
        else return false;
    }
}
