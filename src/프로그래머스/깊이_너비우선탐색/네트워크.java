package 프로그래머스.깊이_너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class 네트워크 {

    public static void main(String[] args) {
        네트워크 test = new 네트워크();

        List<Integer> nTestCases = getNTestCases();
        List<int[][]> computersTestCases  = getComputersTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            int result = test.solution(nTestCases.get(i), computersTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] check = new boolean[computers.length];

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, check, i);
                answer++;
            }
        }
         return answer;
    }

    private void dfs(int[][] computers, boolean[] check, int i) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                dfs(computers, check, j);
            }
        }
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);
        results.add(1);

        return results;
    }



    public static List<Integer> getNTestCases(){
        Integer n1 = 3;
        Integer n2 = 3;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);

        return nList;
    }

    public static List<int[][]> getComputersTestCases(){
        int[][] numbers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] numbers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        List<int[][]> computersList = new ArrayList<>();
        computersList.add(numbers1);
        computersList.add(numbers2);

        return computersList;
    }
}
