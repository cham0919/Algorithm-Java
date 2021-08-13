package 백준.sort;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class 순회강연_2109 {

    // 1. 강의들 기한 순대로 정렬
    // 2. 1일 중 큰 곳 강의 ㄱ
    // 3. 2일 중 큰 곳 강의 ㄱ
    // 4. 3일 중 큰 곳 강의 ㄱ
    // 5. ....

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. max[10001] 배열을 만든다.
        int[] max = new int[10001];

        //2. 입력을 받는다.
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        //3. p(강연료) 기준으로 내림차순 정렬한다.
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        //4. 배열을 순차적으로 돌며,
        // for d -> 0 까지 감소시키며 max[d]와 비교하여 d가 더 클경우 최댓값으로 갱신하고 for문 종료.
        for(int i = 0; i < n; i++) {
            int cost = arr[i][0];
            int dueDate = arr[i][1];
            for(int j = dueDate; j >= 1; j--) {
                if(max[j] < cost) {
                    max[j] = cost;
                    break;
                }
            }
        }
        for(int i = 0; i < 10001; i++)
            sum += max[i];

        System.out.println(sum);
    }
}


