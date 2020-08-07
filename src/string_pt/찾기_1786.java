package string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 찾기_1786 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		ArrayList<Integer> al = KMP(T, P);
		sb.append(al.size()).append('\n');
		for (int i : al) {
			sb.append(i).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb.toString());
	} // end of main

	private static int[] getPi(String pattern) {
		int j = 0;
		int lenOfpattern = pattern.length();
		int[] pi = new int[lenOfpattern];

		for (int i = 1; i < lenOfpattern; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
//		for(int p : pi) {
//			System.out.print(p + " ");
//		}
//		System.out.println();

		return pi;
	} // end of getPi

	private static ArrayList<Integer> KMP(String comp, String pattern) {
		ArrayList<Integer> index = new ArrayList<>();
		int[] pi = getPi(pattern);
		int lenOfcomp = comp.length();
		int lenOfpattern = pattern.length();
		int j = 0;

		for (int i = 0; i < lenOfcomp; i++) {
			while (j > 0 && comp.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (comp.charAt(i) == pattern.charAt(j)) {
				if (j == lenOfpattern - 1) {
					index.add(i - lenOfpattern + 2);
//					System.out.println("index[now] : " + (i - lenOfpattern + 2));
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return index;
	} // end of KMP
} // end of class