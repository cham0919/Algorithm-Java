package 프로그래머스.탐욕법;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰_수_만들기 {

    public static void main(String[] args) {
        큰_수_만들기 test = new 큰_수_만들기();

        List<String> numberTestCases  = getNumberTestCases();
        List<Integer> kTestCases = getKTestCases();
        List<String> results = getResultTestCases();

        for (int i = 0; i < numberTestCases.size(); i++) {
            String result = test.solution2(numberTestCases.get(i), kTestCases.get(i));

            if (result.equals(results.get(i))) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int cnt = number.length() - k;
        int left = 0;
        int right = number.length() - cnt;
        int max = -1;
        int idx = 0;

        while(cnt > 0) {
            max = -1;
            for(int j = left ; j <= right ; ++j){
                int num = number.charAt(j) - '0';
                if(num > max){
                    idx = j;
                    max = num;
                }
            }
            sb.append(number.charAt(idx));
            left = idx + 1;
            right = number.length() - --cnt;
        }

        return sb.toString();
    }

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.empty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    //    ===================================================TEST CASE===========================================================

    public static List<String> getResultTestCases(){
        List<String> results = new ArrayList<>();
        results.add("94");
        results.add("3234");
        results.add("775841");
        results.add("3");
        results.add("1");
        results.add("100");

        return results;
    }




    public static List<String> getNumberTestCases(){
        String numbers1 = "1924";
        String numbers2 = "1231234";
        String numbers3 = "4177252841";
        String numbers4 = "3213";
        String numbers5 = "10001";
        String numbers6 = "1000";

        List<String> lostList = new ArrayList<>();
        lostList.add(numbers1);
        lostList.add(numbers2);
        lostList.add(numbers3);
        lostList.add(numbers4);
        lostList.add(numbers5);
        lostList.add(numbers6);

        return lostList;
    }

    public static List<Integer> getKTestCases(){
        Integer numbers1 = 2;
        Integer numbers2 = 3;
        Integer numbers3 = 4;
        Integer numbers4 = 3;
        Integer numbers5 = 4;
        Integer numbers6 = 1;

        List<Integer> reserveList = new ArrayList<>();
        reserveList.add(numbers1);
        reserveList.add(numbers2);
        reserveList.add(numbers3);
        reserveList.add(numbers4);
        reserveList.add(numbers5);
        reserveList.add(numbers6);

        return reserveList;
    }
}
