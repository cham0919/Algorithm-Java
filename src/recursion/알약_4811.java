package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알약_4811 {
	
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[31][31];
		for (int i=0; i<31; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int n;
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			sb.append(go(n, 0)).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
	
	static long go(int f, int h) {
		if (dp[f][h] != -1) return dp[f][h];
		if (f == 0) {
			return 1;
		} else if (h == 0) {
			return dp[f][h] = go(f-1, h+1);
		} else {
			return dp[f][h] = go(f-1, h+1) + go(f, h-1);
		}
	}
}