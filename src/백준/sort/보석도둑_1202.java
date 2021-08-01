package 백준.sort;

import java.io.*;
import java.util.*;

public class 보석도둑_1202 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] size = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};

            List<int[]> param1 = new ArrayList<>();
            for (int i = 0; i < size[0]; i++) {
                st = new StringTokenizer(br.readLine());
                param1.add(new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())});
            }

            List<Integer> param2 = new ArrayList<>();
            for (int i = 0; i < size[1]; i++) {
                st = new StringTokenizer(br.readLine());
                param2.add(Integer.valueOf(st.nextToken()));
            }

            long result = solution(param1, param2);
            System.out.println(result);
        } catch (IOException e){
            throw new IOException();
        }
    }

    private static long solution(List<int[]> jewel, List<Integer> bags) {
        bags.sort(null);
        jewel.sort(Comparator.comparingInt(o -> o[0]));
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());


        long result = 0;
        int i = 0;
        for (Integer bag : bags) {
            for (;i < jewel.size();) {
                if (jewel.get(i)[0] <= bag) {
                    queue.add(jewel.get(i)[1]);
                    i++;
                } else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                result += queue.poll();
            }

        }

        return result;
    }
}