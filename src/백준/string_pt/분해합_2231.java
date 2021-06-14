package 백준.string_pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 1; i < input; i++) {
			String st = String.valueOf(i);
			int temp = 0;
			for (int j = 0; j < st.length(); j++) {
				temp += st.charAt(j) - 48;
			}
			if((temp += i) == input) {
				if(sum == 0)
					sum = i;
				else
					sum = (sum>i) ? i : sum;
			}
		}

		System.out.println(sum);


	}
}
