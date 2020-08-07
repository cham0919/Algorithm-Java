package string_pt;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱_난장이_2309{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int[] txt = new int[9];
		int[] pat = new int[2];
		int sum = 0;
		
		for (int i = 0; i < txt.length; i++) {
			txt[i] = sc.nextInt();
			sum += txt[i];
		}
		Arrays.sort(txt);
		sum -= 100;
		
		loop:
		for (int i = 0; i < txt.length-1; i++) {
			for (int j = i+1; j < txt.length; j++) {
				if((txt[i]+txt[j]) == sum) {
					pat[0] = i;
					pat[1] = j;
					break loop;
				}
			}
		}
		
		for (int i = 0; i < txt.length; i++) {
			if(i != pat[0] && i != pat[1]) {
				System.out.println(txt[i]);
			}
		}
	}
}