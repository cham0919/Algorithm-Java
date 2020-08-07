package string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 광고_1305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String pat = br.readLine();

		int result = kmpMatch(size, pat);
		System.out.print(result);
		
	}

	public static int kmpMatch(int size, String pat) {

		int pt = 1;
		int pp = 0;
		int[] skip = new int[size+1];


		skip[pt] = pp;
		while (pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			}else if(pp == 0) {
				skip[++pt] = pp;
			}else {
				pp = skip[pp];
			}
		}
			
		return size - skip[skip.length-1];
		
	}
}
