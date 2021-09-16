package 프로그래머스;

import java.util.*;

public class Base3 {


    public static void main(String[] args) {
        Base3 test = new Base3();
        List<int[]> kList = getKTestCases();
        List<Integer> results = getResultTestCases();


        for (int i = 0; i < kList.size(); i++) {

            int result = test.solution2(kList.get(i));

            if (result == results.get(i)) {
                System.out.println("성공 : " + result);
            } else {
                System.out.println("실패 - 제출 : " + result + " / 정답 : " + results.get(i));
            }

        }
    }


    // 증가구간
    // 다 다른 수 -> 일반 정렬 후 -> size - 1
    // 중복된 수 ->
    // 1. 한개 -> 무시
    // 2. 두개 -> 나눔 정렬
    // 3. 세개 -> 니눔 정렬

    // 103,101,103,103,101,102,100,100,101,104

    // 100, 101, 102, 103, 104

    // 100 - 2, 101 - 3, 102 - 1, 103 - 3, 104 - 1
    // [4, 2, 1]
    public int solution2(int[] p) {
        int answer = 0;
        int maxCardCnt = 0;

        Map<Integer, Integer> cardCountMap = getCardCountMap(p);

        for (Integer cardCnt : cardCountMap.values()) {
            answer += cardCnt;
            maxCardCnt = Math.max(maxCardCnt, cardCnt);
        }

        return answer - maxCardCnt;
    }

    private Map<Integer, Integer> getCardCountMap(int[] p) {
        Map<Integer, Integer> cardCountMap = new HashMap<>();
        for (int i : p) {
            int count = cardCountMap.getOrDefault(i, 0) + 1;
            cardCountMap.put(i, count);
        }
        return cardCountMap;
    }


    public int solution(int[] p) {
        int answer = 0;

        List<List<Integer>> answerList = new ArrayList<>();

        for (int i : p) {
            int i1 = 0;
            for (; i1 < answerList.size(); i1++) {
                List<Integer> list = answerList.get(i1);
                if (!list.contains(i)) {
                    list.add(i);
                    break;
                }
            }

            if (i1 == answerList.size()) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                answerList.add(list);
            }
        }

        for (List<Integer> integers : answerList) {
            answer += integers.size()-1;
        }

        return answer;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);
        results.add(2);
        results.add(7);

        return results;
    }

    public static List<int[]> getKTestCases(){
        int[] k1 = {3, 2, 1, 4, 5};
        int[] k2 = {20, 10, 10, 20};
        int[] k3 = {103, 101, 103, 103, 101, 102, 100, 100, 101, 104};

        List<int[]> ks = new ArrayList<>();
        ks.add(k1);
        ks.add(k2);
        ks.add(k3);

        return ks;
    }
}
