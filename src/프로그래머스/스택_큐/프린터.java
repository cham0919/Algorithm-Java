package 프로그래머스.스택_큐;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=python3
 */
public class 프린터 {

    public static void main(String[] args) {
        프린터 test = new 프린터();
        List<int[]> priorities = getPrioritiesTestCases();
        List<Integer> location = getLocationTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < priorities.size(); i++) {

            int result = test.solution(priorities.get(i), location.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }


    public int solution(int[] priorities, int location) {
        Queue<Print> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            Print printElement = new Print()
                    .setPriority(priorities[i])
                    .setResult(i == location);
            queue.add(printElement);
        }

        Arrays.sort(priorities);

        int result = 1;
        int idx = priorities.length - 1;

        while (!queue.isEmpty()) {
            Print print = queue.poll();

            if ( priorities[idx] > print.getPriority() ) {
                queue.add(print);
            } else {
                if( print.isResult() ) break;
                idx --;
                result++;
            }
        }

        return result;
    }

    public class Print{

        int priority;
        boolean result;


        public int getPriority() {
            return priority;
        }

        public Print setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public boolean isResult() {
            return result;
        }

        public Print setResult(boolean result) {
            this.result = result;
            return this;
        }

        @Override
        public String toString() {
            return "Print{" +
                    "priority=" + priority +
                    ", result=" + result +
                    '}';
        }
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        Integer result1 = 1;
        Integer result2 = 5;

        List<Integer> results = new ArrayList<>();
        results.add(result1);
        results.add(result2);

        return results;
    }


    public static List<int[]> getPrioritiesTestCases(){
        int[] priorities1 = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};

        List<int[]> prioritiesList = new ArrayList<>();
        prioritiesList.add(priorities1);
        prioritiesList.add(priorities2);

        return prioritiesList;
    }

    public static List<Integer> getLocationTestCases(){
        int location1 = 2;
        int location2 = 0;

        List<Integer> locationList = new ArrayList<>();
        locationList.add(location1);
        locationList.add(location2);

        return locationList;
    }
}
