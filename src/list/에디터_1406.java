package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class 에디터_1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		LinkedList<Character> str = new LinkedList<>();
		ListIterator<Character> idx = str.listIterator(str.size());
		for(int i=0; i<s.length(); i++)
			idx.add(s.charAt(i));
		int N = Integer.parseInt(br.readLine());

		while(N-->0){
			String cmd = br.readLine();
			try {
				if(cmd.equals("L"))
					idx.previous();
				else if(cmd.equals("D"))
					idx.next();
				else if(cmd.equals("B")) {
					idx.previous();
					idx.remove();
				} else {
					idx.add(cmd.charAt(2));
				}
			} catch (Exception e) {}
		}

		StringBuilder sb = new StringBuilder(600000);
		for(char c : str)
			sb.append(c);
		System.out.println(sb);
	}
}