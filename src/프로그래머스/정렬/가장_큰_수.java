package 프로그래머스.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 가장_큰_수 {

    public static void main(String[] args) {
        가장_큰_수 test = new 가장_큰_수();
        List<int[]> numbersTestCases = getNumbersTestCases();
        List<String> results = getResultTestCases();

        for (int i = 0; i < numbersTestCases.size(); i++) {
            String result = test.solution(numbersTestCases.get(i));

            if (result.equalsIgnoreCase(results.get(i))) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public String solution(int[] numbers) {
        StringBuffer result = new StringBuffer();
        String[] strings = Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ");
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String s : strings) {
            result.append(s);
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }

    //    ===================================================TEST CASE===========================================================

    public static List<String> getResultTestCases(){
        List<String> results = new ArrayList<>();
        results.add("6210");
        results.add("9534330");
        results.add("0");
        results.add("40400");
        results.add("12121");
        results.add("543278934330191");
        results.add("1111111111");
        results.add("52015100");
        results.add("99510010000");
        results.add("10110");
        results.add("10110");

        return results;
    }

    public static List<int[]> getNumbersTestCases(){
        int[] number1 = {6, 10, 2};
        int[] number2 = {3, 30, 34, 5, 9};
        int[] number3 = {0,0,0};
        int[] number4 = {40,400};
        int[] number5 = {12,121};
        int[] number6 = {3, 30, 34, 5, 191, 432789};
        int[] number7 = {1, 11, 111, 1111};
        int[] number8 = {0, 5, 10, 15, 20};
        int[] number9 = {1000, 0, 5, 99, 100};
        int[] number10 = {10, 101};

        List<int[]> numbersList = new ArrayList<>();
        numbersList.add(number1);
        numbersList.add(number2);
        numbersList.add(number3);
        numbersList.add(number4);
        numbersList.add(number5);
        numbersList.add(number6);
        numbersList.add(number7);
        numbersList.add(number8);
        numbersList.add(number9);
        numbersList.add(number10);

        return numbersList;
    }
}
