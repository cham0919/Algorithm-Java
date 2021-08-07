package 백준.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수묶기_1744 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(in.readLine());

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(in.readLine());
        }

        long resNum = solution(size, nums);


        out.write(String.valueOf(resNum));
        out.close();
        in.close();
    }

    private static long solution(int size, int[] nums) {
        // 1. 큰 수끼리는 무조건 묶기
        // 2. 음수끼리는 무조건 묶기
        // 3. 0은 묶지 않기
        // 4. 음수가 하나, 0이 하나 있을 경우 묶기
        PriorityQueue<Integer> postQueue = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> negatQueue = new PriorityQueue();

        int zeroCnt = 0;
        long result = 0;

        for (int num : nums) {
            if (num > 0) {
                postQueue.add(num);
            } else if (num < 0) {
                negatQueue.add(num);
            } else {
                zeroCnt++;
            }
        }

        while (negatQueue.size() >= 2) {
            result += negatQueue.poll() * negatQueue.poll();
        }
        if (negatQueue.size() == 1) {
            result += zeroCnt > 0 ? 0 : negatQueue.poll();
        }

        while (postQueue.size() >= 2) {
            if (postQueue.peek() == 1) break;
            int tmp1 = postQueue.poll();
            if (postQueue.peek() == 1) {
                result += tmp1;
                break;
            }

            int tmp2 = postQueue.poll();
            result += tmp1 * tmp2;
        }

        while (!postQueue.isEmpty()) {
            result += postQueue.poll();
        }

        return result;
    }
}


