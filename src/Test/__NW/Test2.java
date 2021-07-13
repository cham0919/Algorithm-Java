package Test.__NW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Test2 {

    public static void main(String[] args) {
        Test2 test = new Test2();
        List<String> sTestCases = getSTestCases();
        List<String[]> results = getResultTestCases();

        for (int i = 0; i < sTestCases.size(); i++) {
            String[] result = test.solution(sTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", Arrays.toString(result));
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", Arrays.toString(result), Arrays.toString(results.get(i)));
            }
        }
    }



    public String[] solution(String s) {
        List<String> resultList = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        serchAndSubString(resultList, sb);

        return resultList.stream().toArray(String[]::new);
    }

    
    private void serchAndSubString(List<String> resultList, StringBuilder sb) {
        if (sb.length() == 0) return;

        int sIdx = matchIdx(sb);
        if (sIdx > 0) {
            subStringBothSide(resultList, sb, sIdx);
            serchAndSubString(resultList, sb);
        }
    }

    
    private int matchIdx(StringBuilder sb) {
        int sIdx = 1;
        while (!bmMatch(sb, sb.substring(0, sIdx)) && sIdx++ < sb.length());
        return sIdx;
    }

    
    private String subStringBothSide(List<String> resultList, StringBuilder sb, int sIdx) {
        String str = sb.substring(0, sIdx);
        int addIdx = resultList.size()/2;
        
        sb.delete(0, sIdx);
        resultList.add(addIdx, str);

        if (sb.length() >= sIdx) {
            sb.delete(sb.length()-sIdx, sb.length());
            resultList.add(addIdx, str);
        }

        return str;
    }


    private boolean bmMatch(StringBuilder txt, String pat) {
        int pt = txt.length() - pat.length();
        int pp = 0;

        while (txt.charAt(pt) == pat.charAt(pp)) {
            if (pp == pat.length()-1) return true;
            pp++;
            pt++;
        }
        return false;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<String[]> getResultTestCases(){
        List<String[]> results = new ArrayList<>();
        results.add(new String[]{"abc", "xy", "asdf", "asdf", "xy", "abc"});
        results.add(new String[]{"abc", "xy", "qwerty", "xy", "abc"});
        results.add(new String[]{"abc", "abc", "abc", "abc"});
        results.add(new String[]{"l", "l", "t", "t", "a", "a", "t", "t", "l", "l"});
        results.add(new String[]{"z", "z", "z", "z", "z", "z"});
        results.add(new String[]{"abcdef"});

        return results;
    }



    public static List<String> getSTestCases(){
        String s1 = "abcxyasdfasdfxyabc";
        String s2 = "abcxyqwertyxyabc";
        String s3 = "abcabcabcabc";
        String s4 = "llttaattll";
        String s5 = "zzzzzz";
        String s6 = "abcdef";

        List<String> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
        sList.add(s5);
        sList.add(s6);

        return sList;
    }
}
