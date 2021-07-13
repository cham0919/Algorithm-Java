package Test.__KP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#fn1
 */
public class test2 {

    public static void main(String[] args){
        test2 test = new test2();
        List<Integer> rowsTestCases = getRowsTestCases();
        List<Integer> columnssTestCases = getColumnssTestCases();
        List<int[][]> swipesTestCases = getSwipesTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < rowsTestCases.size(); i++) {
            int[] result = test.solution(rowsTestCases.get(i), columnssTestCases.get(i), swipesTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", Arrays.toString(result));
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", Arrays.toString(result), Arrays.toString(results.get(i)));
            }
        }
    }

    private int[] solution(int rows, int columns, int[][] swipes) {
        int[][] array = new int[rows][columns];
        int[] result = new int[swipes.length];
        int init = 1;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                array[i][i1] = init;
                init++;
            }
        }

        int direction = 0;
        int idx = 0;
        for (int[] swipe : swipes) {
            direction = swipe[0];
            result[idx++] = getResult(array, direction, swipe);
        }
        return result;
    }

    private int getResult(int[][] array, int direction, int[] swipe) {
        int result = 0;

        if (direction == 1){
            int[] tmpArray = new int[swipe[4] - swipe[2] + 1];
            result += getUpDownResult(swipe[2]-1, swipe[4]-1, swipe[3]-1, array, tmpArray);
            for (int i = swipe[1]-1; i <= swipe[3]-1; i++) {
                moveColumn(swipe[2]-1, swipe[4]-1, i, array, tmpArray);
            }
        } else if (direction == 2) {
            int[] tmpArray = new int[swipe[4] - swipe[2] + 1];
            result += getUpDownResult(swipe[2]-1, swipe[4]-1, swipe[1]-1, array, tmpArray);
            for (int i = swipe[3]-1; i >= swipe[1]-1; i--) {
                moveColumn(swipe[2]-1, swipe[4]-1, i, array, tmpArray);
            }
        } else if (direction == 3) {
            int[] tmpArray = new int[swipe[3] - swipe[1] + 1];
            result += getLeftRightResult(swipe[1]-1, swipe[3]-1, swipe[4]-1, array, tmpArray);
            for (int i = swipe[2]-1; i <= swipe[4]-1; i++) {
                moveRow(swipe[1]-1, swipe[3]-1, i, array, tmpArray);
            }
        } else if (direction == 4) {
            int[] tmpArray = new int[swipe[3] - swipe[1] + 1];
            result += getLeftRightResult(swipe[1]-1, swipe[3]-1, swipe[2]-1, array, tmpArray);
            for (int i = swipe[4]-1; i >= swipe[2]-1; i--) {
                moveRow(swipe[1]-1, swipe[3]-1, i, array, tmpArray);
            }
        }
        return result;
    }

    private void moveRow(int startJIdx, int endJIdx, int i, int[][] array, int[] tmpArray) {
        int idx = 0;
        for (int j = startJIdx; j <= endJIdx; j++) {
            int tmpVal =  array[j][i];
            array[j][i] = tmpArray[idx];
            tmpArray[idx++] = tmpVal;
        }
    }

    private void moveColumn(int startJIdx, int endJIdx, int i, int[][] array, int[] tmpArray) {
        int idx = 0;
        for (int j = startJIdx; j <= endJIdx; j++) {
            int tmpVal =  array[i][j];
            array[i][j] = tmpArray[idx];
            tmpArray[idx++] = tmpVal;
        }
    }


    private int getUpDownResult(int startIdx, int endIdx, int tmpIdx, int[][] array, int[] tmpArray) {
        int result = 0;
        int idx = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            tmpArray[idx++] = array[tmpIdx][i];
            result += array[tmpIdx][i];
        }
        return result;
    }

    private int getLeftRightResult(int startIdx, int endIdx, int tmpIdx, int[][] array, int[] tmpArray) {
        int result = 0;
        int idx = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            tmpArray[idx++] = array[i][tmpIdx];
            result += array[i][tmpIdx];
        }
        return result;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        List<int[]> results = new ArrayList<>();
        results.add(new int[]{23, 3, 21, 9});
        results.add(new int[]{12, 10, 5, 20});
        results.add(new int[]{2, 4, 3, 2});

        return results;
    }

    public static List<Integer> getRowsTestCases(){
        int array1 = 4;
        int array2 = 2;
        int array3 = 2;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<Integer> getColumnssTestCases(){
        int array1 = 3;
        int array2 = 4;
        int array3 = 2;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }

    public static List<int[][]> getSwipesTestCases(){
        int[][] array1 = {{1, 1, 2, 4, 3}, {3, 2, 1, 2, 3}, {4, 1, 1, 4, 3}, {2, 2, 1, 3, 3}};
        int[][] array2 = {{3, 1, 2, 2, 4}, {3, 1, 2, 2, 4}, {4, 2, 1, 2, 3}, {1, 1, 1, 2, 3}};
        int[][] array3 = {{3, 1, 1, 1, 2}, {1, 1, 2, 2, 2}, {4, 2, 1, 2, 2}, {2, 1, 1, 2, 1}};

        List<int[][]> citationsList = new ArrayList<>();
        citationsList.add(array1);
        citationsList.add(array2);
        citationsList.add(array3);

        return citationsList;
    }
}
