package programmers.exhaustive_search;

public class MinRectangle {
    public int solution(int[][] sizes) {
        int w1 = 0;
        for(int i = 0; i < sizes.length; i++) {
            w1 = Math.max(w1, sizes[i][0]);
            w1 = Math.max(w1, sizes[i][1]);
        }

        int w2 = 0;
        for(int i = 0; i < sizes.length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            w2 = Math.max(w2, min);
        }

        return w1 * w2;
    }
}
