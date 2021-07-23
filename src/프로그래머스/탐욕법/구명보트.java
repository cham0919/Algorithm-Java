package 프로그래머스.탐욕법;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class 구명보트 {


    public static void main(String[] args) {
        구명보트 test = new 구명보트();

        List<int[]> numberTestCases  = getPeopleTestCases();
        List<Integer> kTestCases = getLimitTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numberTestCases.size(); i++) {
            Integer result = test.solution(numberTestCases.get(i), kTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int leftIdx = 0;
        int rightIdx = people.length-1;
        int count = 0;

        while (leftIdx <= rightIdx) {
            int small = people[leftIdx];

            while (((limit - small) < people[rightIdx]) && leftIdx < rightIdx-- )  {
                count++;
            }


            leftIdx++;
            rightIdx--;
            count++;
        }

        return count;
    }

    public int solution2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(3);
        results.add(3);
        results.add(4);

        return results;
    }



    public static List<int[]> getPeopleTestCases(){
        int[] n1 = {70, 50, 80, 50};
        int[] n2 = {70, 80, 60};
        int[] n3 = {50, 50, 50, 50,50,50,50};

        List<int[]> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);
        nList.add(n3);

        return nList;
    }


    public static List<Integer> getLimitTestCases(){
        Integer n1 = 100;
        Integer n2 = 100;
        Integer n3 = 100;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);
        nList.add(n3);

        return nList;
    }
}
