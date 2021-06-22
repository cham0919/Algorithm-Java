package 프로그래머스.완전탐색;


import java.util.*;


/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
public class 모의고사 {

    public static void main(String[] args){
        모의고사 test = new 모의고사();
        List<int[]> answersTestCases = getAnswersTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < answersTestCases.size(); i++) {
            int[] result = test.solution(answersTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int[] solution(int[] answers) {
        Map<Integer, Integer> ansMap = new HashMap<>();
        List<Integer> answer = new LinkedList<>();
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        for (int i = 0; i < answers.length; i++) {
            if (answer1[i%5] == answers[i]) { ansMap.put(1, ansMap.getOrDefault(1, 0)+1); }
            if (answer2[i%8] == answers[i]) { ansMap.put(2, ansMap.getOrDefault(2, 0)+1); }
            if (answer3[i%10] == answers[i]) { ansMap.put(3, ansMap.getOrDefault(3, 0)+1); }
        }

        if (ansMap.size() > 0) {
            int max = 0;
            for(Map.Entry<Integer, Integer> entry : ansMap.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    answer.clear();
                    answer.add(entry.getKey());
                } else if (max == entry.getValue()){
                    answer.add(entry.getKey());
                }
            }
            answer.sort((o1, o2) -> o1.compareTo(o2));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }


    public static int[] solution2(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        for(int i = 0; i < answers.length; i++) {
            if (answer1[i%5] == answers[i]) { result1++; }
            if (answer2[i%8] == answers[i]) { result2++; }
            if (answer3[i%10] == answers[i]) { result3++; }
        }

        int max = Math.max(result1, Math.max(result2, result3));
        List<Integer> list = new ArrayList<>();
        if (max == result1) {list.add(1);}
        if (max == result2) {list.add(2);}
        if (max == result3) {list.add(3);}

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        List<int[]> results = new ArrayList<>();
        results.add(new int[]{1});
        results.add(new int[]{1, 2, 3});
        results.add(new int[]{1, 3});
        results.add(new int[]{});

        return results;
    }

    public static List<int[]> getAnswersTestCases(){
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        int[] answers3 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] answers4 = {5,4,4,2,1};

        List<int[]> answersList = new ArrayList<>();
        answersList.add(answers1);
        answersList.add(answers2);
        answersList.add(answers3);
        answersList.add(answers4);

        return answersList;
    }
}
