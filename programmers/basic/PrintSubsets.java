package programmers.basic;

public class PrintSubsets {

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D'};
        solution(data);
    }

    public static void solution(char[] data) {

        for(int i = 0; i < (1 << data.length); i++) {
            System.out.print("{");
            String e = "";
            for(int j = 0; j < data.length; j++) {
                if((i & (1 << j)) != 0)
                    e += data[j] + ", ";
            }
            if(!e.equals("")) e = e.substring(0, e.length() - 2);
            System.out.println(e + "}");
        }
    }
}
