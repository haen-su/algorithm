package hash;

import java.util.HashMap;

public class FailedRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> p = new HashMap<>();
        HashMap<String, Integer> c = new HashMap<>();

        for(String name : participant) {
            if(p.containsKey(name)) {
                p.replace(name, p.get(name) + 1);
            } else {
                p.put(name, 1);
            }
        }

        for(String name : completion) {
            if(c.containsKey(name)) {
                c.replace(name, c.get(name) + 1);
            } else {
                c.put(name, 1);
            }
        }

        for(String key: p.keySet()) {
            if(!p.get(key).equals(c.get(key))) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
