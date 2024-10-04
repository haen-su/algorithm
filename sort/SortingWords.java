package sort;
import java.util.*;

public class SortingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        String[] words;

        for (int i = 0; i < N; i++)
            set.add(sc.nextLine());
        words = set.toArray(new String[0]);

        solution(words);
    }

    public static void solution(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                return s1.length() - s2.length();
            }
        });

        for (String s : words)
            System.out.println(s);
    }
}
