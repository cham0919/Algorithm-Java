package 프로그래머스.탐욕법;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 */
public class 단속카메라 {


    public static void main(String[] args) {
        단속카메라 test = new 단속카메라();

        List<int[][]> numberTestCases  = getRoutesTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numberTestCases.size(); i++) {
            Integer result = test.solution(numberTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparing(o -> o[1]));

        int cam = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);

        return results;
    }



    public static List<int[][]> getRoutesTestCases(){
        int[][] n1 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};

        List<int[][]> nList = new ArrayList<>();
        nList.add(n1);

        return nList;
    }

}
