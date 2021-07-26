package 프로그래머스.동적계획법;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길 {

    public static void main(String[] args) {
        등굣길 test = new 등굣길();
        List<Integer> target = getMTestCases();
        List<Integer> numbers = getNTestCases();
        List<int[][]> puddlesTestCases = getPuddlesTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numbers.size(); i++) {
            int result = test.solution(numbers.get(i), target.get(i), puddlesTestCases.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패 :: " + result + " ::"  + results.get(i));
            }
        }
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] road = new int[m+1][n+1];


        // road 초기화
        road[1][1] = 1;

        for (int[] puddle : puddles) {
            road[puddle[0]][puddle[1]] = -1;
        }


        // 계산
        for (int i = 1; i < road.length; i++) {
            for (int j = 1; j < road[i].length; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else if (road[i][j] == -1) {
                    road[i][j] = 0;
                    continue;
                } else {
                    road[i][j] = (road[i][j-1] + road[i-1][j]) %  1_000_000_007;
                }
            }
        }

        return road[m][n] ;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);

        return results;
    }



    public static List<Integer> getNTestCases(){
        Integer target1 = 3;

        List<Integer> targets = new ArrayList<>();
        targets.add(target1);

        return targets;
    }

    public static List<Integer> getMTestCases(){
        Integer numbers1 = 4;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(numbers1);

        return numbers;
    }

    public static List<int[][]> getPuddlesTestCases(){
        int[][] numbers1 = {{2, 2}};

        List<int[][]> numbers = new ArrayList<>();
        numbers.add(numbers1);

        return numbers;
    }
}
