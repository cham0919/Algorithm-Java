package 프로그래머스.힙;

import java.util.*;

public class 이중우선순위큐 {


    public static void main(String[] args) {
        이중우선순위큐 test = new 이중우선순위큐();
        List<String[]> operationsTestCases = getOperationsTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < operationsTestCases.size(); i++) {
            int[] result = test.solution(operationsTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", Arrays.toString(result));
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", Arrays.toString(result), Arrays.toString(results.get(i)));
            }
        }
    }

    Queue<Integer> defaultQueue = new PriorityQueue<>();
    Queue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        defaultQueue = new PriorityQueue<>();
        reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            operationStr(operations[i]);
        }
        int[] result;
        if (defaultQueue.isEmpty()) {
            result = new int[]{0, 0};
        } else {
            result = new int[]{reverseQueue.poll(), defaultQueue.poll()};
        }
        return result;
    }

    private void operationStr(String operation) {
        String[] array = operation.split(" ");
        int value = Integer.valueOf(array[1]);
        if (array[0].equalsIgnoreCase("I")) {
            defaultQueue.add(value);
            reverseQueue.add(value);
        } else if (value < 0) {
            reverseQueue.remove(defaultQueue.poll());
        } else {
            defaultQueue.remove(reverseQueue.poll());
        }
    }

//    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        List<int[]> results = new ArrayList<>();
        results.add(new int[]{0, 0});
        results.add(new int[]{7, 5});
        results.add(new int[]{0, 0});
        results.add(new int[]{333, -45});
        results.add(new int[]{5, 5});

        return results;
    }

    public static List<String[]> getOperationsTestCases(){
        String[] operations1 = {"I 16","D 1"};
        String[] operations2 = {"I 7","I 5","I -5","D -1"};
        String[] operations3 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations4 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operations5 = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};

        List<String[]> operationsList = new ArrayList<>();
        operationsList.add(operations1);
        operationsList.add(operations2);
        operationsList.add(operations3);
        operationsList.add(operations4);
        operationsList.add(operations5);

        return operationsList;
    }

}
