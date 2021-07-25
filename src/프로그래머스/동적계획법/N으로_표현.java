package 프로그래머스.동적계획법;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */
public class N으로_표현 {

    public static void main(String[] args) {
        N으로_표현 test = new N으로_표현();
        List<Integer> numbers = getNTestCases();
        List<Integer> target = getNumbersTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numbers.size(); i++) {
            int result = test.solution(numbers.get(i), target.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패 :: " + result + " ::"  + results.get(i));
            }
        }
    }


    private int n;
    private int target;
    private int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        n = N;
        target = number;
        answer = Integer.MAX_VALUE;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);
        results.add(-1);

        return results;
    }



    public static List<Integer> getNTestCases(){
        Integer target1 = 5;
        Integer target2 = 5;

        List<Integer> targets = new ArrayList<>();
        targets.add(target1);
        targets.add(target2);

        return targets;
    }

    public static List<Integer> getNumbersTestCases(){
        Integer numbers1 = 12;
        Integer numbers2 = 31168;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(numbers1);
        numbers.add(numbers2);

        return numbers;
    }
}
