package bruteforce;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 1; i <= yellow; i++) {
            int y1 = i;
            int y2 = (brown + 4) / 2 - 4 - y1;

            if(y1 * y2 == yellow) {
                answer[0] = Math.max(y1, y2) + 2;
                answer[1] = Math.min(y1, y2) + 2;
                break;
            }
        }

        return answer;
    }
}



