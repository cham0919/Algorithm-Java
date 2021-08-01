package 백준.sort;

import java.io.*;
import java.util.*;

public class 보물_1026 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.valueOf(br.readLine());

            List<Integer> param1 = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                param1.add(Integer.valueOf(st.nextToken()));
            }

            List<Integer> param2 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                param2.add(Integer.valueOf(st.nextToken()));
            }

            int result = solution(size, param1, param2);
            System.out.println(result);
        } catch (IOException e){
            throw new IOException();
        }
    }

    private static int solution(int size, List<Integer> param1, List<Integer> param2) {
        param2.sort(null);
        param1.sort(Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < size; i++) {
            result += param1.get(i) *  param2.get(i);
        }

        return result;
    }
}
