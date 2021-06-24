package 프로그래머스.완전탐색;

import java.util.*;

/**
 *https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
 */
public class 카펫 {

    public static void main(String[] args){
        카펫 test = new 카펫();
        List<Integer> brownTestCases = getBrownTestCases();
        List<Integer> yellowTestCases = getYellowTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < brownTestCases.size(); i++) {
            int[] result = test.solution(brownTestCases.get(i), yellowTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    private int[] solution(int brown, int yellow) {
        // 약수 구하기
        int[] result = new int[2];
        Set<Integer> divisorSet = getDivisorSet(yellow);

        System.out.println(divisorSet);

        // 둘레 구하기
        int round = 0;

        for (Integer length : divisorSet) {
            round = getRound(length, yellow);
            if (brown == round) {
                result[0] = length + 2;
                result[1] = yellow/length + 2;
            }
        }

        return result;
    }

    private int getRound(Integer length, int yellow) {
        return 2*(length + (yellow/length)) + 4;
    }

    private Set<Integer> getDivisorSet(int num) {
        Set<Integer> divisorSet = new HashSet<>();
        addDivisorSet(divisorSet, num);
        return divisorSet;
    }

    private void addDivisorSet(Set<Integer> divisorSet, int num) {
        for (int i = 1; i <= num/2+1; i++) {
            if (num%i == 0) {
                divisorSet.add(i);
            }
        }
    }

    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        List<int[]> results = new ArrayList<>();
        results.add(new int[]{4, 3});
        results.add(new int[]{3, 3});
        results.add(new int[]{8, 6});

        
        return results;
    }

    public static List<Integer> getBrownTestCases(){
        Integer answers1 = 10;
        Integer answers2 = 8;
        Integer answers3 = 24;

        List<Integer> brownList = new ArrayList<>();
        brownList.add(answers1);
        brownList.add(answers2);
        brownList.add(answers3);

        return brownList;
    }

    public static List<Integer> getYellowTestCases(){
        Integer answers1 = 2;
        Integer answers2 = 1;
        Integer answers3 = 24;

        List<Integer> yellowList = new ArrayList<>();
        yellowList.add(answers1);
        yellowList.add(answers2);
        yellowList.add(answers3);

        return yellowList;
    }
}
