package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class Base2 {


    public static void main(String[] args) {
        Base2 test = new Base2();
        List<String> kList = getKTestCases();
        List<Integer> results = getResultTestCases();


        for (int i = 0; i < kList.size(); i++) {

            int result = test.solution(kList.get(i));

            if (result == results.get(i)) {
                System.out.println("성공 : " + result);
            } else {
                System.out.println("실패 - 제출 : " + result + " / 정답 : " + results.get(i));
            }

        }
    }


    public int solution(String plain) {
         char[] plainCharArray = plain.toCharArray();

        int addCharIdx = 0;

        for (int i = 0; i < plainCharArray.length; i++) {
            if (isPalindrome(plainCharArray, addCharIdx)) {
                 break;
            } else {
                addCharIdx++;
            }
        }

        return plainCharArray.length + addCharIdx;
    }

    private boolean isPalindrome(char[] plainCharArray, int addCharIdx) {
        int targetIdx = 0;

        int reverseIdx = plainCharArray.length - 1;
        boolean reverseFlag = addCharIdx <= 0 ? true : false;

        for (int i = 0; i <= (plainCharArray.length + addCharIdx)/2; i++) {
            if (!reverseFlag && targetIdx >= addCharIdx) {
                reverseFlag = true;
            }

            if (reverseFlag) {
                targetIdx = reverseIdx--;
            } else {
                targetIdx = i;
            }

            if (plainCharArray[i] != plainCharArray[targetIdx++]) {
                return false;
            }
        }
        return true;
    }




    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(5);
        results.add(9);

        return results;
    }

    public static List<String> getKTestCases(){
        String k1 = "abab";
        String k2 = "abcde";

        List<String> ks = new ArrayList<>();
        ks.add(k1);
        ks.add(k2);

        return ks;
    }
}
