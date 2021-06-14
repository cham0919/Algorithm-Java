package 백준.string_pt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 균형잡힌세상_4949 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String string;
//		
//		while (!(string = br.readLine()).equals(".")) {
//			
//		bw.write(chk(string));
//		bw.flush();
//		}
		
	    while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                bw.flush();
                return;
            }

            bw.write(chk(input));
        }
	}
	
	public static String chk(String string) {
		
		char[] stack = new char[string.length()-1];
		int curser = 0;
		boolean result = true;
		
			
			for (char c : string.toCharArray()) {
			switch (c) {
			case '(':	
			case '[': 	stack[curser++] = c;		break;
			case ')': 	if(curser == 0 || stack[--curser] != '(') return "no\n";  break;
			case ']': 	if(curser == 0 || stack[--curser] != '[') return "no\n";  break;	
			}
		}

			if (curser > 0) {
            result = false;
        }

        return result ? "yes\n" : "no\n";
	}
	
}