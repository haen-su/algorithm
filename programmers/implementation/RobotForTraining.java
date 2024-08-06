package programmers.implementation;

import java.util.*;

public class RobotForTraining {
    public int[] solution(String command) {
        Queue<String> q = new LinkedList<>();

        for(int i = 0 ; i < command.length(); i++)
            q.offer(command.charAt(i) + "");

        int x = 0;
        int y = 0;
        // 0 위 1는 오른쪽 2은 아래 3는 왼쪽 방향 헤드
        int h = 0;

        while(!q.isEmpty()) {
            String poll = q.poll();

            if(poll.equals("R")) {
                h += 1;
            }
            if(poll.equals("L")) {
                h -= 1;
            }
            if(poll.equals("G")) {
                int r = h % 4;
                if(r >= 0) {
                    if(r == 0) y++;
                    else if(r == 1) x++;
                    else if(r == 2) y--;
                    else x--;
                } else {
                    if(r == 0) y++;
                    else if(r == -1) x--;
                    else if(r == -2) y--;
                    else x++;
                }
            }
            if(poll.equals("B")) {
                int r = h % 4;
                if(r >= 0) {
                    if(r == 0) y--;
                    else if(r == 1) x--;
                    else if(r == 2) y++;
                    else x++;
                } else {
                    if(r == 0) y--;
                    else if(r == -1) x++;
                    else if(r == -2) y++;
                    else x--;
                }
            }
        }

        return new int[]{x, y};
    }
}