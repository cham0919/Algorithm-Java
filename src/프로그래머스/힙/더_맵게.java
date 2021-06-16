package 프로그래머스.힙;


import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더_맵게 {


    public static void main(String[] args) {
        더_맵게 test = new 더_맵게();
        List<int[]> scovilleList = getScovilleTestCases();
        List<Integer> kList = getKTestCases();
        List<Integer> results = getResultTestCases();


        for (int i = 0; i < scovilleList.size(); i++) {

            int result = test.solution(scovilleList.get(i), kList.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        }
    }


    public  int solution(int[] scoville, int k) {
        Queue<Integer> queue = initQueue(scoville);
        int result = 1;

        for (; result < scoville.length; result++) {
            mixScoville(queue);
            if (queue.peek() >= k ) {
                return result;
            }
        }
        return -1;
    }

    private int mixScoville(Queue<Integer> queue) {
        int minScoville = queue.poll();
        int secondMinScoville = queue.poll();
        int mixScoville = minScoville + (secondMinScoville * 2);
        queue.add(mixScoville);
        return mixScoville;
    }

    private Queue<Integer> initQueue(int[] scoville) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        return queue;
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
