package Test.__NW;

import java.util.ArrayList;
import java.util.List;


public class Test3 {

    public static void main(String[] args) {
        Test3 test = new Test3();
        List<String> sTestCases = getSTestCases();
        List<String> tTestCases = getTTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < sTestCases.size(); i++) {
            int result = test.solution(sTestCases.get(i), tTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(String s, String t) {
        int result = 0;
        int idx;
        int tSize = t.length();
        StringBuilder sb = new StringBuilder(s);

        while ((idx = sb.indexOf(t)) >= 0) {
            sb.delete(idx, idx+tSize);
            result++;
        }

        return result;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);
        results.add(5);

        return results;
    }



    public static List<String> getSTestCases(){
        String s1 = "aabcbcd";
        String s2 = "aaaaabbbbb";

        List<String> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);

        return sList;
    }

    public static List<String> getTTestCases(){
        String t1 = "abc";
        String t2 = "ab";

        List<String> tList = new ArrayList<>();
        tList.add(t1);
        tList.add(t2);

        return tList;
    }
}
