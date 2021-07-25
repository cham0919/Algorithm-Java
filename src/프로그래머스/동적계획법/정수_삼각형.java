package 프로그래머스.동적계획법;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105?language=python3
 */
public class 정수_삼각형 {

    public static void main(String[] args) {
        정수_삼각형 test = new 정수_삼각형();
        List<int[][]> numbers = getTriangleTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numbers.size(); i++) {
            int result = test.solution2(numbers.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    public int solution(int[][] triangle) {

        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] layer = triangle[i];

            for (int i1 = 0; i1 < layer.length; i1++) {
                layer[i1] += Math.max(triangle[i+1][i1], triangle[i+1][i1+1]);
            }
        }

        return triangle[0][0];
    }

    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(30);

        return results;
    }



    public static List<int[][]> getTriangleTestCases(){
        int[][] target1 = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        List<int[][]> targets = new ArrayList<>();
        targets.add(target1);

        return targets;
    }

}
