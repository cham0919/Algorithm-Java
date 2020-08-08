package heap;

import java.util.*;

public class 디스크_컨트롤러_programmers {

	public static void main(String[] args) {

		int[][] jobs = {{0,3},{1,9},{2,6},{2,2}};
		solution(jobs);
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		int[] a = {1,2};
		
		
		while (idx < len || !q.isEmpty()) {
			System.out.println("한바큉");
			while (idx < len && jobs[idx][0] <= time) {
				System.out.println(time+"에"+jobs[idx][0]+"작업 요청");
				q.offer(jobs[idx++]);
			}
			
			if (q.isEmpty()) {
				System.out.println(time+"에"+jobs[idx][0]+"작업 바로 완료");
				time = jobs[idx][0];
			}
			else {
				int[] job = q.poll();
				System.out.println(time+"에"+job[0]+"작업 완료");
				answer += time - job[0] + job[1];
				time += job[1];
				System.out.println(q.size()+"만큼 들어있다"+"idx는 >"+idx);
			}
		}
		System.out.println(answer / len);
		return answer / len;
	}
}
