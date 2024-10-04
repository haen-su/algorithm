package basic;

// 배열에 있는 정수 중 두 수의 합이 n인 경우의 수 구하기

public class Sum7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(solution(7, array));
    }

    public static int solution(int n, int[] array) {
        int count = 0;

        for(int i = 0; i < (1 << array.length); i++) {
            int sum = 0;

            if(Integer.bitCount(i) == 2) {      // 만약 두 수라는 제한이 없다면 이 조건문 빼기
                for(int j = 0; j < array.length; j++) {
                    if((i & (1 << j)) != 0) sum += array[j];
                }

                if(sum == n) count++;
            }
        }
        return count;
    }
}
