package programmers.dfs_bfs;

public class TargetNumber {
    static public String[] operations = {"-", "+"};
    static public int cnt = 0;

    public int solution(int[] numbers, int target) {
        operation("", numbers, target);
        return cnt;
    }

    public void operation(String sequence, int[] numbers, int target) {
        if(sequence.length() == numbers.length) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                sum = sum + Integer.parseInt(sequence.charAt(i) + Integer.toString(numbers[i]));
            }
            if(sum == target) cnt++;
            return;
        }

        for(int i = 0; i < operations.length; i++) {
            operation(sequence + operations[i], numbers, target);
        }
    }
}
