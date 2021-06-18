package 프로그래머스.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://programmers.co.kr/learn/courses/30/lessons/42748?language=python3
 */
public class K번째수 {

    public static void main(String[] args) {
        K번째수 test = new K번째수();
        List<int[]> arrayTestCases = getArrayTestCases();
        List<int[][]> commandsTestCases = getCommandsTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < arrayTestCases.size(); i++) {
            int[] result = test.solution(arrayTestCases.get(i), commandsTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", Arrays.toString(result));
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", Arrays.toString(result), Arrays.toString(results.get(i)));
            }
        }
    }


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for (int[] command : commands) {
            int[] result = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(result);
            answer[idx++] = result[command[2]-1];
        }
        
        return answer;
    }


//    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        List<int[]> results = new ArrayList<>();
        results.add(new int[]{5, 6, 3});

        return results;
    }

    public static List<int[]> getArrayTestCases(){
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};

        List<int[]> arrayList = new ArrayList<>();
        arrayList.add(array1);

        return arrayList;
    }

    public static List<int[][]> getCommandsTestCases(){
        int[][] commands1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        List<int[][]> commandsList = new ArrayList<>();
        commandsList.add(commands1);

        return commandsList;
    }
}
