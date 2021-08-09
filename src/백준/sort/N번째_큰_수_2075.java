package 백준.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N번째_큰_수_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> arrayQueue = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arrayQueue.add(temp);
        }

        for(int i = 1; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(arrayQueue.peek() < temp) {  // 추가
                    arrayQueue.poll();
                    arrayQueue.add(temp);
                }
            }
        }
        System.out.println(arrayQueue.poll());
    }
}
