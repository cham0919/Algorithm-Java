package Test.__KP;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#fn1
 */
public class test1 {

    public static void main(String[] args){
        test1 test = new test1();
        List<Integer> moneyTestCases = getMoneyTestCases();
        List<Integer> minratioTestCases = getMinratioTestCases();
        List<Integer> maxratioTestCases = getMaxratioTestCases();
        List<Integer> ranksizeTestCases = getRanksizeTestCases();
        List<Integer> thresholdTestCases = getThresholdTestCases();
        List<Integer> monthsTestCases = getMonthsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < moneyTestCases.size(); i++) {
            int result = test.solution(moneyTestCases.get(i),
                    minratioTestCases.get(i), maxratioTestCases.get(i),
                    ranksizeTestCases.get(i), thresholdTestCases.get(i)
            ,monthsTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        // 매달 말에 징수
        // m의 백의자리 미만은 버림하고 계산
        // threshold 미만이면, 세금 걷지 않음
        // threshold 이상이면, ranksize 올라갈 때마다 세율 1% 증가
        // 상한 세율 maxratio
        // 이 시민이 보유하게 될 금액
        // 추가 수입 없음

        // m의 백의자리 미만은 버림하고 계산
        int ratioMoney = money/100*100;

        for (int i = 0; i < months; i++) {
            // threshold 이상이면, ranksize 올라갈 때마다 세율 1% 증가
            if (ratioMoney >= threshold) {
                double ratio = getRatio(ratioMoney, threshold, maxratio, ranksize, minratio, 0);
                int tax = (int) (ratioMoney * (ratio/100));
                money = money - tax;
                ratioMoney = money/100*100;
            } else {
                break;
            }
        }
        return money;
    }

    private double getRatio(int money, int threshold, int maxratio, int ranksize, int ratio, int rank) {
        if (ratio >= maxratio) {
            return maxratio;
        } else if ((threshold + (rank * ranksize)) <= money && money < (threshold + ((rank+1) * ranksize))) {
            return ratio;
        } else {
            return getRatio(money, threshold, maxratio, ranksize, ratio+1, rank+1);
        }
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(9000014);
        results.add(6150);
        results.add(123456789);

        return results;
    }

    public static List<Integer> getMoneyTestCases(){
        int array1 = 12345678;
        int array2 = 1000000000;
        int array3 = 123456789;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getMinratioTestCases(){
        int array1 = 10;
        int array2 = 50;
        int array3 = 0;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getMaxratioTestCases(){
        int array1 = 20;
        int array2 = 99;
        int array3 = 0;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getRanksizeTestCases(){
        int array1 = 250000;
        int array2 = 100000;
        int array3 = 1;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getThresholdTestCases(){
        int array1 = 10000000;
        int array2 = 0;
        int array3 = 0;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getMonthsTestCases(){
        int array1 = 4;
        int array2 = 6;
        int array3 = 360;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }
}
