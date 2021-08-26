package 백준.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대_거리_2381 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(br.readLine());

        int sumMaxLine = Integer.MIN_VALUE;
        int sumMinLine = Integer.MAX_VALUE;
        int minusMaxLine = Integer.MIN_VALUE;
        int minusMinLine = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startIdx = Integer.valueOf(st.nextToken());
            int endIdx = Integer.valueOf(st.nextToken());
            sumMaxLine = Math.max(sumMaxLine, startIdx+endIdx);
            sumMinLine = Math.min(sumMinLine, startIdx+endIdx);
            minusMaxLine = Math.max(minusMaxLine, startIdx-endIdx);
            minusMinLine = Math.min(minusMinLine, startIdx-endIdx);
        }

        System.out.println(Math.max((sumMaxLine-sumMinLine), (minusMaxLine-minusMinLine)));
    }
}
