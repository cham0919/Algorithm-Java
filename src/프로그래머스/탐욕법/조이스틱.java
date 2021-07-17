package 프로그래머스.탐욕법;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
 */
public class 조이스틱 {


    public static void main(String[] args) {
        조이스틱 test = new 조이스틱();

        List<String> nTestCases = getNameTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            int result = test.solution(nTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(String name) {
        int answer = 0;

        int len = name.length();

        //최대로 가질 수 있는 min값은 끝까지 가는것
        int min_move = len-1;

        for(int i=0; i<len; i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
            int next = i+1;// 현재 다음 위치부터
            //내 다음이 A라면 계속 NEXT++
            while(next<len && name.charAt(next) == 'A')
                next++;

            min_move = Math.min(min_move, i+len-next + i);
        }//for

        answer += min_move;

        return answer;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(56);
        results.add(23);
        results.add(0);
        results.add(1);

        return results;
    }



    public static List<String> getNameTestCases(){
        String n1 = "JEROEN";
        String n2 = "JAN";
        String n3 = "AAAAAA";
        String n4 = "BAAAAA";

        List<String> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);
        nList.add(n3);
        nList.add(n4);

        return nList;
    }
}
