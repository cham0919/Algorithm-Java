package 백준.sort;

import java.io.*;
import java.util.*;

public class 숫자의신_1422 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] size = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
            Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder((o1, o2) -> (o1+o2).compareTo(o2+o1)));
            int max = 0;
            for (int i = 0; i < size[0]; i++) {
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                max = Math.max(max, tmp.length());
                queue.add(tmp);
            }

            String result = solution(max, queue, size[1]);
            System.out.println(result);
        } catch (IOException e){
            throw new IOException();
        }
    }

    private static String solution(int max, Queue<String> queue, int n) {
        StringBuilder sb = new StringBuilder();

        int loopSize = n - (queue.size()-1);
        boolean loopFlag = true;
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (loopFlag && tmp.length() == max) {
                for (int i = 0; i < loopSize-1; i++) {
                    sb.append(tmp);
                }
                loopFlag = false;
            }
            sb.append(tmp);
        }

        return sb.toString();
    }
}