package sort;

import java.util.*;

class FindMinValue {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int Amin = 0;
        int Amax = A.length - 1;
        int Bmin = 0;
        int Bmax = B.length - 1;

        int sum = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[Amin] * B[Bmax] >= A[Amax] * B[Bmin]) {
                sum += A[Amin] * B[Bmax];
                Amin++;
                Bmax--;
            } else {
                sum += A[Amax] * B[Bmin];
                Amax--;
                Bmin++;
            }

        }

        return sum;

    }
}
