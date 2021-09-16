package 프로그래머스;

import 프로그래머스.힙.더_맵게;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Base {


    public static void main(String[] args) {
        Base test = new Base();
        List<int[]> scovilleList = getScovilleTestCases();
        List<Integer> kList = getKTestCases();
        List<Integer> results = getResultTestCases();


        for (int i = 0; i < scovilleList.size(); i++) {

            int result = test.solution();

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        }
    }


    public int solution() {
        return 0;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);

        return results;
    }


    public static List<int[]> getScovilleTestCases(){
        int[] scoville1 = {1, 2, 3, 9, 10, 12};

        List<int[]> scovilles = new ArrayList<>();
        scovilles.add(scoville1);

        return scovilles;
    }

    public static List<Integer> getKTestCases(){
        Integer k1 = 7;

        List<Integer> ks = new ArrayList<>();
        ks.add(k1);

        return ks;
    }
}
