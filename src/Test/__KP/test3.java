package Test.__KP;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#fn1
 */
public class test3 {

    public static void main(String[] args){
        test3 test = new test3();
        List<String> getline1TestCases = getline1TestCases();
        List<String> getline2TestCases = getline2TestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < getline1TestCases.size(); i++) {
            int result = test.solution(getline1TestCases.get(i), getline2TestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    private int solution(String line1, String line2) {
        char[] line1CharArray = line1.toCharArray();

        char[] compareCharArray = line2.toCharArray();
        int interval = 0;
        int result = 0;
        for (int i = 0; i < line1CharArray.length; i++) {
            if (line1CharArray[i] == compareCharArray[0]) {
                while ((i + compareCharArray.length + ((compareCharArray.length-1) * interval)) <= line1CharArray.length) {
                    if (matchStr(line1CharArray, compareCharArray, i, interval)) {
                        result++;
                    }
                    interval++;
                }
                interval = 0;
            }
        }
        return result;
    }



    private boolean matchStr(char[] line1CharArray, char[] compareCharArray, int line1idx, int interval) {
        for (int i = 0; i < compareCharArray.length ; i++, line1idx += interval+1) {
            if (line1CharArray[line1idx] != compareCharArray[i]) {
                return false;
            }
        }
        return true;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);
        results.add(4);
        results.add(0);

        return results;
    }

    public static List<String> getline1TestCases(){
        String array1 = "abbbcbbb";
        String array2 = "abcabcabc";
        String array3 = "abacaba";

        List<String> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }
    public static List<String> getline2TestCases(){
        String array1 = "bbb";
        String array2 = "abc";
        String array3 = "acb";

        List<String> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }
}
