package 프로그래머스.이분탐색;

import 프로그래머스.정렬.H_Index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 입국심사 {

    public static void main(String[] args){
        입국심사 test = new 입국심사();
        List<Integer> nTestCases = getNTestCases();
        List<int[]> timesTestCases = getTimesTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            long result = test.solution(nTestCases.get(i), timesTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min=1;//최적의 경우 1초로 초기화
        long max=(long)times[times.length-1]*n;//최악의 경우로 초기화
        long mid=0;
        long sum;
        long answer = max;
        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int time:times){
                sum+=mid/time;//심사관 당 맡을 수 있는 입국자 수
            }
            if(sum>=n){//더 맡을 수 있으므로 시간 줄임
                if(mid<answer){
                    answer=mid;
                }
                max=mid-1;
            }
            else{//불가하므로 시간 늘림
                min=mid+1;
            }
        }
        return answer;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(28);

        return results;
    }

    public static List<Integer> getNTestCases(){
        int array1 = 6;

        List<Integer> citationsList = new ArrayList<>();
        citationsList.add(array1);

        return citationsList;
    }

    public static List<int[]> getTimesTestCases(){
        int[] array1 = {7, 10};

        List<int[]> citationsList = new ArrayList<>();
        citationsList.add(array1);

        return citationsList;
    }
}
