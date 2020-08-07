package heap;

import java.util.*;

public class 더_맵게_programmers {

	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		
		solution(scoville, K);
	}

	public static int solution(int[] scoville, int K) {
		
		Queue<Integer> pq = new PriorityQueue<Integer>(scoville.length);
		int result = 0, temp1 = 0, temp2 = 0;
		for (Integer i : scoville) {
			pq.offer(i);
		}
		
		while (pq.peek() <= K) {
			
			if(pq.size() == 1) return -1;
			
			temp1 = pq.poll();
			temp2 = pq.poll();
			pq.offer(temp1 + (temp2*2));
			
			result++;
		}
		return result;
	}
}
