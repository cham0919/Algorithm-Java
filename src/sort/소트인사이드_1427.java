package sort;

import java.io.*;
import java.util.Arrays;

public class 소트인사이드_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bo = new BufferedOutputStream(System.out);
		char[] result = br.readLine().toCharArray();
		
		Arrays.sort(result);
		
		for (int i = result.length-1; i >= 0; i--) {
			bo.write(result[i]);
		}
		
		bo.flush();
	}
}