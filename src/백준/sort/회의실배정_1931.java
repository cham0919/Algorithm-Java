package 백준.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실배정_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] lessionRoom = new int[size][2];
        int[] lessionCount = new int[size];
        StringTokenizer st;

        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            lessionRoom[i] = temp;
        }
        Arrays.sort(lessionRoom, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] ints : lessionRoom) {
            System.out.println(Arrays.toString(ints));
        }

        int max = 0;
        int endLessionTime = 0;

        for (int[] ints : lessionRoom) {
            if (endLessionTime <= ints[0]) {
                max++;
                endLessionTime = ints[1];
            }
        }


        System.out.println(max);
    }
}
