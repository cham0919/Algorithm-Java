package stack_queue;

import java.util.ArrayList;
import java.util.Stack;

public class 기능개발_programmers {

	public static void main(String[] args) {

		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		
		solution(progresses, speeds);
		
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for (int i = progresses.length-1; i >= 0; i--) {
			st.push(progresses[i]);
			st.push(speeds[i]);
		}
		
		int day = 1;
		
		while (!st.empty()) {
			int speed = st.pop();
			int now = st.pop();

			while (now+(speed*day) < 100) {
				day++;
			}
//			System.out.println(now+"가 "+day+"번째 날 완성되었습니다");
			
			resultList.add(bepo(st, day));
			
		}
		
		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		
//		System.out.println(Arrays.toString(result));
		
		return result;
	}
	
	public static int bepo(Stack<Integer> st, int day) {
		
		int speed = 0;
		int now = 0;
		int result = 1;
		
		while (!st.empty()) {
			if(((speed = st.pop())*day)+(now=st.pop()) >= 100) {
//				System.out.println("이 날"+now+"도 함께 배포됩니다");
				result++;
				continue;
			}else {
				st.push(now);
				st.push(speed);
				break;
			}
		}
		
		return result;
	}

}
