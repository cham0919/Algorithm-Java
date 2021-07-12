package 프로그래머스.탐욕법;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class 체육복 {

    public static void main(String[] args) {
        체육복 test = new 체육복();

        List<Integer> nTestCases = getNTestCases();
        List<int[]> lostTestCases  = getLostTestCases();
        List<int[]> reserveTestCases  = getReserveTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            int result = test.solution(nTestCases.get(i), lostTestCases.get(i), reserveTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        IntStream.of(lost).forEach(i -> students[i] -= 1);
        IntStream.of(reserve).forEach(i -> students[i] += 1);
        IntStream.of(reserve)
                .filter(i -> students[i] == 1)
                .forEach(i -> {
                    if ((i-1) > 0 && students[i-1] == -1) {
                        students[i-1] += 1;
                    } else if ((i+1) <= n && students[i+1] == -1){
                        students[i+1] += 1;
                    } });
        return (int)IntStream.range(1, n+1)
                .filter(i -> students[i] >= 0)
                .count();
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(5);
        results.add(4);
        results.add(2);
        results.add(4);

        return results;
    }



    public static List<Integer> getNTestCases(){
        Integer n1 = 5;
        Integer n2 = 5;
        Integer n3 = 3;
        Integer n4 = 5;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);
        nList.add(n3);
        nList.add(n4);

        return nList;
    }

    public static List<int[]> getLostTestCases(){
        int[] numbers1 = {2, 4};
        int[] numbers2 = {2, 4};
        int[] numbers3 = {3};
        int[] numbers4 = {2, 3, 4};

        List<int[]> lostList = new ArrayList<>();
        lostList.add(numbers1);
        lostList.add(numbers2);
        lostList.add(numbers3);
        lostList.add(numbers4);

        return lostList;
    }

    public static List<int[]> getReserveTestCases(){
        int[] numbers1 = {1, 3, 5};
        int[] numbers2 = {3};
        int[] numbers3 = {1};
        int[] numbers4 = {1, 2, 3};

        List<int[]> reserveList = new ArrayList<>();
        reserveList.add(numbers1);
        reserveList.add(numbers2);
        reserveList.add(numbers3);
        reserveList.add(numbers4);

        return reserveList;
    }
}
