package 프로그래머스.깊이_너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class 단어_변환 {

    public static void main(String[] args) {
        단어_변환 test = new 단어_변환();

        List<String> beginTestCases = getBeginTestCases();
        List<String> targetTestCases  = getTargetTestCases();
        List<String[]> wordsTestCases = getWordsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < beginTestCases.size(); i++) {
            int result = test.solution(beginTestCases.get(i), targetTestCases.get(i), wordsTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] check = new boolean[words.length];


        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                check[i] = true;
                break;
            } else if ( i == words.length-1) {
                return 0;
            }
        }
        int[] result = {Integer.MAX_VALUE};
        dfs(words, check, target, begin, 0, result);
        return result[0];
    }

    private void dfs(String[] words, boolean[] check, String target, String begin, int count,  int[] result) {
        if (isPossibleChange(target, begin)) {
            count++;
            result[0] = result[0] > count ? count : result[0];
        }
        for (int i = 0; i < words.length; i++) {
            if (check[i]) { continue; }
            if (isPossibleChange(target, words[i])) {
                check[i] = true;
                dfs(words, check, words[i], begin, count+1, result);
                check[i] = false;
            }
        }
    }

    private boolean isPossibleChange(String target, String word) {
        char[] a = target.toCharArray();
        char[] b = word.toCharArray();
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            if ( a[i] - b[i] != 0 ) result++;
            if (result >= 2) return false;
        }
        return true;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);
        results.add(0);

        return results;
    }



    public static List<String> getBeginTestCases(){
        String begin1 = "hit";
        String begin2 = "hit";

        List<String> begins = new ArrayList<>();
        begins.add(begin1);
        begins.add(begin2);

        return begins;
    }

    public static List<String> getTargetTestCases(){
        String target1 = "cog";
        String target2 = "cog";

        List<String> targets = new ArrayList<>();
        targets.add(target1);
        targets.add(target2);

        return targets;
    }

    public static List<String[]> getWordsTestCases(){
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        List<String[]> words = new ArrayList<>();
        words.add(words1);
        words.add(words2);

        return words;
    }
}
