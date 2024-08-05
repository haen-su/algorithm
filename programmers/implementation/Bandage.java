package programmers.implementation;

public class Bandage {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int time = 0;
        int max = health;
        for(int i = 0; i < attacks.length; i++) {
            if(time + bandage[0] >= attacks[i][0]) {
                health = Math.min(max, health + (attacks[i][0] - time - 1) * bandage[1]);
                health -= attacks[i][1];
                time = attacks[i][0];
            } else {
                int s = attacks[i][0] - time;
                // 체력 = 현재 체력 + 초당회복량 + 추가회복량
                health = Math.min(max, health + (bandage[1] * (s - 1) + (bandage[2] * ((s - 1) / bandage[0]))));
                health -= attacks[i][1];
                time = attacks[i][0];
            }

            if(health <= 0) return -1;
        }

        return health;
    }
}
