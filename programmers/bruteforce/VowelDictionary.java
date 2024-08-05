package programmers.bruteforce;

import java.util.*;

public class VowelDictionary {

    String[] vowels;
    List<String> dictionary;

    public int solution(String word) {
        int answer = 0;
        vowels = new String[5];
        dictionary = new ArrayList<>();

        vowels[0] = "A";
        vowels[1] = "E";
        vowels[2] = "I";
        vowels[3] = "O";
        vowels[4] = "U";


        findWord("");

        List<String> words = new ArrayList<>();

        for(String w : dictionary) {
            words.add(w);
        }


        Collections.sort(words);

        for(String w : words) {
            System.out.println(w);
        }

        answer = words.indexOf(word) + 1;
        return answer;
    }

    public void findWord(String word) {
        if(word.length() > 5)
            return;

        if(word != "")
            dictionary.add(word);

        for(int i = 0; i < vowels.length; i++) {
            findWord(word + vowels[i]);
        }
    }
}
