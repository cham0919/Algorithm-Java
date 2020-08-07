package string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] bp = new int[N+2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N; i > 0; i--) {
			int day = i+T[i];
			
			if(day <= N+1) {
				bp[i] = Math.max(P[i]+bp[day], bp[i+1]);
			}else {
				bp[i] = bp[i+1];
			}
		}
		
		System.out.println(bp[1]);
		

	}
}