package Test.__NW;

import java.util.*;


public class Test1 {

    public static void main(String[] args) {
        Test1 test = new Test1();
        List<int[]> pricesTestCases = getPricesTestCases();
        List<int[]> discountsTestCases = getDiscountsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < pricesTestCases.size(); i++) {
            int result = test.solution(pricesTestCases.get(i), discountsTestCases.get(i));

            if (result ==  results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(int[] prices, int[] discounts) {
        sortArrays(prices, discounts);
        return applyDiscount(prices, discounts, 0);
    }

    private int applyDiscount(int[] prices, int[] discounts, int answer) {
        int priceIdx = prices.length-1;
        int discountIdx = discounts.length-1;

        for (; discountIdx >= 0; discountIdx--, priceIdx--) {
            answer += prices[priceIdx]/100 * ((100 - discounts[discountIdx]));
        }

        for (int i = priceIdx; i >= 0; i--) {
            answer += prices[priceIdx];
        }

        return answer;
    }

    private void sortArrays(int[] ...  array) {
        for (int[] ints : array) {
            Arrays.sort(ints);
        }
    }

    public int solution2(int[] prices, int[] discounts) {
        int answer = 0;
        int priceIdx = prices.length-1;
        int discountIdx = discounts.length-1;
        Arrays.sort(prices);
        Arrays.sort(discounts);


        System.out.println(3300 * 0.2);

        return answer;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(82000);
        results.add(45275);

        return results;
    }



    public static List<int[]> getPricesTestCases(){
        int[] price1 = {13000, 88000, 10000};
        int[] price2 = {32000, 18000, 42500};

        List<int[]> pricesList = new ArrayList<>();
        pricesList.add(price1);
        pricesList.add(price2);

        return pricesList;
    }

    public static List<int[]> getDiscountsTestCases(){
        int[] discounts1 = {30, 20};
        int[] discounts2 = {50, 20, 65};

        List<int[]> discountsList = new ArrayList<>();
        discountsList.add(discounts1);
        discountsList.add(discounts2);

        return discountsList;
    }
}
