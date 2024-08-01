package programmers.hash;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> ghm = new HashMap<>();
        HashMap<Integer, Integer> phm = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(ghm.containsKey(genres[i])) {
                ghm.replace(genres[i], ghm.get(genres[i]) + plays[i]);
            } else {
                ghm.put(genres[i], plays[i]);
            }
            phm.put(i, plays[i]);
        }

        List<String> gkeySet = new ArrayList<>(ghm.keySet());
        List<Integer> pkeySet = new ArrayList<>(phm.keySet());

        gkeySet.sort((o1, o2) -> ghm.get(o2).compareTo(ghm.get(o1)));
        pkeySet.sort((o1, o2) -> phm.get(o2).compareTo(phm.get(o1)));

        for(String genre : gkeySet) {
            int cnt = 0;
            for(Integer index : pkeySet) {
                if(genres[index].equals(genre)) {
                    answer.add(index);
                    cnt++;
                }
                if(cnt == 2) break;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
