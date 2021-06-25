package 프로그래머스.깊이_너비우선탐색;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class 타겟_넘버 {


    public static void main(String[] args) {
        타겟_넘버 test = new 타겟_넘버();
        List<int[]> numbers = getNumbersTestCases();
        List<Integer> target = getTargetTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numbers.size(); i++) {
            int result = test.solution(numbers.get(i), target.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    int answer = 0;

    public int solution(int[] numbers, int target) {
        getDfs(numbers, numbers[0], 0, target);
        getDfs(numbers, -1 * numbers[0], 0, target);

        return answer;
    }

    public void getDfs(int[] numbers, int num, int depth, int target) {
        if(depth == numbers.length - 1) {
            if(num == target) {
                answer++;
            }
            return;
        }

        getDfs(numbers, num + numbers[depth + 1], depth + 1, target);
        getDfs(numbers, num - numbers[depth + 1], depth + 1, target);
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(5);

        return results;
    }



    public static List<Integer> getTargetTestCases(){
        Integer target1 = 3;

        List<Integer> targets = new ArrayList<>();
        targets.add(target1);

        return targets;
    }

    public static List<int[]> getNumbersTestCases(){
        int[] numbers1 = {1, 1, 1, 1, 1};

        List<int[]> numbers = new ArrayList<>();
        numbers.add(numbers1);

        return numbers;
    }
}
