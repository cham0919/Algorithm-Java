package 프로그래머스.스택_큐;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {

    public static void main(String[] args) {
        주식가격 test = new 주식가격();
        List<int[]> prices = getPricesTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < prices.size(); i++) {
            int[] result = test.solution(prices.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    public int[] solution(int[] prices) {

        int[] result = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            int cnt = 0;
            for (int j = i+1; j < prices.length; j++) {
                cnt++;
                if (price > prices[j]) { break; }
            }
            result[i] = cnt;
        }

        return result;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        int[] result1 = {4, 3, 1, 1, 0};

        List<int[]> results = new ArrayList<>();
        results.add(result1);

        return results;
    }


    public static List<int[]> getPricesTestCases(){
        int[] progresses1 = {1, 2, 3, 2, 3};

        List<int[]> progressesList = new ArrayList<>();
        progressesList.add(progresses1);

        return progressesList;
    }

}
