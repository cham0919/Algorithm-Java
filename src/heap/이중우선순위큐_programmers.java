package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐_programmers {

	public static void main(String[] args) {

		String[] operations = {"I 16","D 1"};
		System.out.println(Arrays.toString(solution(operations)));
	}
	
	public static int[] solution(String[] operations) {
		
		int temp = 0;
		StringTokenizer st;
		PriorityQueue<Integer> pqmin = new PriorityQueue<>(operations.length);
		PriorityQueue<Integer> pqmax = new PriorityQueue<>(operations.length, Collections.reverseOrder());
		
		for (String s : operations) {
			st = new StringTokenizer(s);
			
			switch (st.nextToken()) {
			case "I":
				temp = Integer.parseInt(st.nextToken());
				pqmin.offer(temp);
				pqmax.offer(temp);
				break;
			case "D":
				temp = Integer.parseInt(st.nextToken());
				if(!pqmin.isEmpty())
				if(temp == 1) {
					pqmin.remove(pqmax.poll());
				}else {
					pqmax.remove(pqmin.poll());
				}
				break;
			}
		}
		
		int[] result = new int[2];
		
		if(pqmin.isEmpty()) {
			result[0] = 0;
			result[1] = 0;
		}else {
			result[0] = pqmax.poll();
			result[1] = pqmin.poll();
		}
		
		return result;
	}

}
