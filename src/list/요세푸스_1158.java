package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 요세푸스_1158 {
	
	public static void main(String[] args) throws IOException {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   int N = Integer.parseInt(st.nextToken());
		   int M = Integer.parseInt(st.nextToken());
		   int n = 0;
		   ArrayList<Integer> link = new ArrayList<>();
		   StringBuilder sb = new StringBuilder("<");
		   
		   for(int i=0 ; i<N ; i++){
			   link.add(i+1);
		   }
		   while(!link.isEmpty()){
			   n = (n+M-1)%N;
			   sb.append(link.get(n));
			   if(N!=1){
				   sb.append(", ");
			   }
			   link.remove(n);
			   N--;
		   }
		   sb.append(">");
		   System.out.println(sb);
		}
	}