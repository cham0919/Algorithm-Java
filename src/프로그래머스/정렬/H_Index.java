package 프로그래머스.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#fn1
 */
public class H_Index {

    public static void main(String[] args){
        H_Index test = new H_Index();
        List<int[]> citationsTestCases = getCitationsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < citationsTestCases.size(); i++) {
            int result = test.solution(citationsTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(3);
        results.add(4);
        results.add(2);

        return results;
    }

    public static List<int[]> getCitationsTestCases(){
        int[] array1 = {0, 1, 4, 5, 6};
        int[] array2 = {0,1,2,3,3,3,3,3,4,4,10,20,30,40};
        int[] array3 = {88, 89};

        List<int[]> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }
}
