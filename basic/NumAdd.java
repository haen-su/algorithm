package basic;

class NumAdd {
    public int solution(int[] numbers) {
        boolean[] nums = new boolean[10];

        for(int i = 0; i < numbers.length; i++) {
            nums[numbers[i]] = true;
        }

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if(!nums[i])
                answer += i;
        }

        return answer;
    }
}
