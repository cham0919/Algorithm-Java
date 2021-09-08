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
            if ((o1[1] - o2[1]) == 0) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] ints : lessionRoom) {
            System.out.println(Arrays.toString(ints));
        }


        int max = Integer.MIN_VALUE;
        lessionCount[lessionRoom.length - 1] = 1;
        for (int i = lessionRoom.length - 2; i >= 0; i--) {
            int[] lession = lessionRoom[i];
            int[] postLession = lessionRoom[i+1];
            lessionCount[i] = 1;

            if (lession[1] <= postLession[0]) {
                lessionCount[i] += lessionCount[i+1];
            } else {
                for (int i1 = i + 2; i1 < lessionRoom.length; i1++) {
                    postLession = lessionRoom[i1];
                    if (lession[1] <= postLession[0]) {
                        lessionCount[i] += lessionCount[i1];
                        break;
                    }
                }
            }
            max = Math.max(max, lessionCount[i]);
        }
        System.out.println(max);
    }
}
