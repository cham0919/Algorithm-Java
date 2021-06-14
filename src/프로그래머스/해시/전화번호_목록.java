package 프로그래머스.해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */
public class 전화번호_목록 {

    public static void main(String[] args) {
        전화번호_목록 test = new 전화번호_목록();
        List<String[]> phone_books = getPhoneBookTestCases();
        List<Boolean> results = getResultTestCases();

        for (int i = 0; i < phone_books.size(); i++) {
            boolean result = test.solution(phone_books.get(i));
            if (result == results.get(i)){
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }


    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for (int i=1; i<phoneBook.length; i++) {
            if (phoneBook[i].startsWith(phoneBook[i-1])) {
                return false;
            }
        }
        return true;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<String[]> getPhoneBookTestCases(){
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        List<String[]> phoneBooks = new ArrayList<>();
        phoneBooks.add(phone_book1);
        phoneBooks.add(phone_book2);
        phoneBooks.add(phone_book3);

        return phoneBooks;
    }

    public static List<Boolean> getResultTestCases(){
        Boolean result1 = false;
        Boolean result2 = true;
        Boolean result3 = false;

        List<Boolean> results = new ArrayList<>();
        results.add(result1);
        results.add(result2);
        results.add(result3);

        return results;
    }
}
