package 백준.sort;

import java.io.*;
import java.util.*;

public class 수열_정렬_1015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        int[] resultArray = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(array));

        int[] sortedArray = Arrays.stream(array)
                .sorted()
                .toArray();

        int recordIVal = -1;
        int overlapCnt = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            for (int i1 = 0; i1 < array.length; i1++) {
                if (sortedArray[i] == array[i1]) {
                    if (recordIVal == i1) {
                        overlapCnt++;
                        resultArray[i1] = i + overlapCnt;
                    } else {
                        resultArray[i1] = i;
                        recordIVal = i1;
                        overlapCnt = 0;
                    }
                    array[i1] = -1;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(resultArray));

        for (int i = 0; i < resultArray.length - 1; i++) {
            System.out.print(resultArray[i] + " ");
        }

        System.out.print(resultArray[resultArray.length - 1]);

    }
}



