package 프로그래머스.동적계획법;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
 */
public class 도둑질 {

    public static void main(String[] args) {
        도둑질 test = new 도둑질();
        List<int[]> target = getMoneyTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < target.size(); i++) {
            int result = test.solution(target.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패 :: " + result + " ::"  + results.get(i));
            }
        }
    }

    public int solution(int[] money) {
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];

        dp[0]=money[0];
        dp[1]=money[0];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }

        return Math.max(dp[length-2],dp2[length-1]);
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);

        return results;
    }



    public static List<int[]> getMoneyTestCases(){
        int[] target1 = {1, 2, 3, 1};

        List<int[]> targets = new ArrayList<>();
        targets.add(target1);

        return targets;
    }
}
