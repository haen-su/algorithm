package hash;

import java.util.*;

public class IsolatedAlphabet {
    public String solution(String input_string) {
        HashMap<String, Integer> hm = new HashMap<>();
        String answer = "";

        for(char c = 'a'; c <= 'z'; c++) {
            int cnt = 0;
            for(int i = 0; i < input_string.length(); i++) {
                if(c == input_string.charAt(i)) cnt++;
            }
            hm.put(c + "", cnt);
        }

        List<String> list = new ArrayList<>();

        for(int i = 0; i < input_string.length(); i++) {
            char alpha = input_string.charAt(i);
            if(hm.get(alpha + "") != -1) {
                int cnt = 0;
                for(int j = i; j < input_string.length(); j++) {
                    if(input_string.charAt(j) == alpha) cnt++;
                    else break;
                }
                System.out.println(alpha + " " + cnt);
                if(hm.get(alpha + "") != cnt)
                    list.add(alpha + "");
                hm.put(alpha + "" , -1);
            }
        }

        Collections.sort(list);
        for(String l : list)
            answer += l;

        return (answer.equals("")) ? "N" : answer;
    }
}
