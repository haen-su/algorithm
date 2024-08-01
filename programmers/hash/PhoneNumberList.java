package programmers.hash;

import java.util.Arrays;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].indexOf(phone_book[i]) == 0)
                return false;
        }
        return true;
    }
}
