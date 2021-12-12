package 백준.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1946
public class 신입사원_1946 {

//  다른 사원들과 비교하여 둘 다 하위일 때, 탈락
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCnt = Integer.parseInt(br.readLine());


        // 서류 1순위, 면접 1순위

        PriorityQueue<int[]> applicantScoreQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int[] scoreArray;


        for(int i = 0; i < testCaseCnt; i++) {
            int successfulApplicantCnt = 0;
            int applicantCnt = Integer.parseInt(br.readLine());
            for (int i1 = 0; i1 < applicantCnt; i1++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scoreArray = new int[2];
                scoreArray[0] = Integer.parseInt(st.nextToken());
                scoreArray[1] = Integer.parseInt(st.nextToken());
                applicantScoreQueue.add(scoreArray);
            }
            successfulApplicantCnt = solution(applicantScoreQueue);
            System.out.println(successfulApplicantCnt);
        }
    }

    public static int solution(PriorityQueue<int[]> applicantScoreQueue){
        int successfulApplicantCnt = 1;
        int[] previousScoreArray;
        previousScoreArray = applicantScoreQueue.poll();

        while (!applicantScoreQueue.isEmpty()) {
            int[] currentScoreArray = applicantScoreQueue.poll();
            if (currentScoreArray[1] < previousScoreArray[1]) {
                successfulApplicantCnt++;
                previousScoreArray = currentScoreArray;
            }
        }

        return successfulApplicantCnt;
    }
}
