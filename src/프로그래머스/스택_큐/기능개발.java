package 프로그래머스.스택_큐;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=python3
 */
public class 기능개발 {

    public static void main(String[] args) {
        기능개발 test = new 기능개발();
        List<int[]> progresses = getProgressesTestCases();
        List<int[]> speeds = getSpeedsTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < progresses.size(); i++) {
            int[] result = test.solution(progresses.get(i), speeds.get(i));
            
            if (Arrays.equals(result, results.get(i))) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> resultMap = new TreeMap<>();
        int days = 0;

        for (int i = 0; i < progresses.length; i++) {
            double mock = (double)(100 - progresses[i])/speeds[i];
            int tmpDays = (int)Math.ceil(mock);
            days = days > tmpDays ? days : tmpDays;
            resultMap.put(days, resultMap.getOrDefault(days, 0) + 1);
        }

        int[] result = new int[resultMap.size()];
        int idx = 0;
        for (int i : resultMap.values()){
            result[idx++] = i;
        }

        return result;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        int[] result1 = {2, 1};
        int[] result2 = {1, 3, 2};

        List<int[]> results = new ArrayList<>();
        results.add(result1);
        results.add(result2);

        return results;
    }


    public static List<int[]> getProgressesTestCases(){
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};

        List<int[]> progressesList = new ArrayList<>();
        progressesList.add(progresses1);
        progressesList.add(progresses2);

        return progressesList;
    }

    public static List<int[]> getSpeedsTestCases(){
        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        List<int[]> speedsList = new ArrayList<>();
        speedsList.add(speeds1);
        speedsList.add(speeds2);

        return speedsList;
    }
}
