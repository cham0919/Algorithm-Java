package 백준.backtracking;

import java.util.Scanner;

public class N_Queen_9663 {

	static boolean[] flag_a;
	static boolean[] flag_b;
	static boolean[] flag_c;
	static int[] flag;
	static int size;
	static int result = 0;
	
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		flag_a = new boolean[size];
		flag_b = new boolean[size*2-1];
		flag_c = new boolean[size*2-1];
		
		move(0);
		System.out.println(result);
		
	}
	
	static void move(int i) {
		for (int j = 0; j < size; j++) {
			if(flag_a[j] == false && flag_b[i+j] == false && flag_c[i-j+(size-1)] == false) {
				if(i == (size-1)) {
					result++;
				}else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+(size-1)] = true;
					move(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+(size-1)] = false;
				}
			}
		}
	}
}