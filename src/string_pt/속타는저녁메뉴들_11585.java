package string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 속타는저녁메뉴들_11585 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer st2;

		int size = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		st2 = new StringTokenizer(br.readLine(), " ");
		char[] pat = new char[size];
		char[] txt = new char[size*2-1];

		for (int i = 0; i < size; i++) {
			pat[i] =  st.nextToken().charAt(0);
			txt[i] =  st2.nextToken().charAt(0);
		}

		for (int i = size; i < size*2-1; i++) {
			txt[i] = txt[i-size];
			
		}
		
		match(txt, pat, size);

	}


	public static void match(char[] txt, char[] pat, int size) {

		int tp = 1;
		int pp = 0;
		int cnt = 0;
		int size2 = size*2-1;
		int[] skip = new int[size+1];

		skip[tp] = pp;

		while (tp != size) {
			if(pat[tp] == pat[pp]) {
				skip[++tp] = ++pp;
			}else if(pp == 0) {
				skip[++tp] = pp;
			}else {
				pp = skip[pp];
			}// 건너뛰기 표
		}

		tp = pp = 0;
		while (tp != size2) {
			if(txt[tp] == pat[pp]) {
				tp++;
				pp++;
			}else if(pp == 0) {
				tp++;
			}else {
				pp = skip[pp];
			}
			if(pp == size) {
				pp = skip[pp];
				cnt++;
			}
		}

		// 4/8, 8/12, 
			int result = gcd(cnt, size);
			
			cnt = cnt/result;
			size = size/result;
		
		System.out.println(cnt+"/"+size);
		
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}