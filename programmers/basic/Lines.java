package programmers.basic;

import java.util.*;

public class Lines {

    public static void main(String[] args) {
        solution(new int[][]{{0, 5}, {3, 9}, {1, 0}});
    }
    public static int solution(int[][] lines) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for(int i = -100; i <= 99; i++)
            hm.put(i, false);

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int answer = 0;
        for(int i = 0; i < lines.length - 1; i++) {
            for(int j = i + 1; j < lines.length; j++) {
                if(lines[i][1] > lines[j][0]) {
                    int min = Math.min(lines[i][1], lines[j][1]);
                    for(int k = 0; k < min - lines[j][0] ; k++) {
                        if(!hm.get(lines[j][0] + k)) {
                            hm.put(lines[j][0] + k, true);
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
