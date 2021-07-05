package 프로그래머스.그래프;

import java.util.*;

public class 순위 {

    public static void main(String[] args) {
        순위 test = new 순위();
        List<Integer> nTestCases = getNTestCases();
        List<int[][]> resultTestCases = getResultTestCases();
        List<Integer> returnTestCases = getReturnTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            int result = test.solution(nTestCases.get(i), resultTestCases.get(i));

            if (result == returnTestCases.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, returnTestCases.get(i));
            }
        }
    }


    private boolean changed;
    public int solution(int n, int[][] results) {
        //승패 보드
        int[][] resultBoard = new int[n][n];

        //1씩 감소 and 승패보드 기록
        for(int i=0; i< results.length; i++){
            results[i][0]--;
            results[i][1]--;
            int idxWinner = results[i][0];
            int idxloser = results[i][1];
            resultBoard[idxWinner][idxloser] = 1;
            resultBoard[idxloser][idxWinner] = -1;
        }

        changed = true;
        //검사
        while(changed){
            changed = false;
            for(int i=0; i< n; i++){
                for(int j=0; j<n; j++){
                    if(resultBoard[i][j] == 1) resultBoard[i] = mergeResultWin( resultBoard[i], resultBoard[j]);
                    else if(resultBoard[i][j] == -1) resultBoard[i] = mergeResultLose( resultBoard[i], resultBoard[j]);
                }
            }
        }

        //선수 수 확인
        return checkReturnN(resultBoard, n);

    }

    //최종 확인
    private int checkReturnN(int[][] result,int n){
        int count = 0;
        for(int i=0; i<result.length ; i++){
            int rCount = n-1;
            for(int j=0; j<result[0].length; j++){
                if(result[i][j] != 0) rCount--;
            }
            if(rCount == 0) count++;
        }
        return count;
    }

    // 승리 번호 merge
    private int[] mergeResultWin(int[] a, int[] target){
        for(int i=0; i<a.length; i++){
            if(target[i] == 1 && a[i] != 1) {
                a[i] = 1;
                changed = true;
            }
        }
        return a;
    }
    // 패배 번호 merge
    private int[] mergeResultLose(int[] a, int[] target){
        for(int i=0; i<a.length; i++){
            if(target[i] == -1 && a[i] != -1) {
                a[i] = -1;
                changed = true;
            }
        }
        return a;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getReturnTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);

        return results;
    }

    public static List<int[][]> getResultTestCases(){
        List<int[][]> results = new ArrayList<>();
        results.add(new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

        return results;
    }


    public static List<Integer> getNTestCases(){
        Integer n1 = 5;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);

        return nList;
    }
}
