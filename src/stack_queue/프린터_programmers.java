package stack_queue;

public class 프린터_programmers {

	static int max = 0;
	static Printer last;


	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 2;
		//		프린터_programmers ma = new 프린터_programmers();
		solution(priorities, location);
	}

	public static int solution(int[] priorities, int location) {

		Printer head = new Printer(null, -1);
		Printer temp = head;
		Printer pick = null;
		int result = 0;

		for (int i = 0; i < priorities.length; i++) {
			temp.next = new Printer(temp, priorities[i]); 			// 다음 프린트 연결
			temp = temp.next;									// temp 최신화
			last = temp;										// 마지막 노드 최신화
			if(max < priorities[i]) max = priorities[i];		// 최대 우선순위 최신화
			if(i == location) pick = temp;						// 내가 선택한 프린트
		}// 복사 완료

		temp = head.next;
		
		while(true) {

			if(temp.idx < max) {
				temp.prior.next = temp.next;			// 노드 삭제
				last = last.next = temp;				// 마지막 노드 다음에 잇기 
				last.prior = last;						// 마지막 노드 이전에 잇기
				
				temp = temp.next;						// temp 최신화
				continue;
			}else if(temp.idx == max) {					// 최고가 같다면
				result++;								// 프린트 출력
				if(temp == pick) break;					// 선택한 작업이라면
				max= 0;									// 최대 초기화
				max_update(temp.next);
			}

			temp = temp.next;
		}


		
		return result;
	}


	public static void max_update(Printer temp) {
		
		while (temp != last) {
			if(max < temp.idx) max = temp.idx;
			temp = temp.next;
		} // 마지막 노드까지 순환하면서 최대값 다시 설정
		if(max < temp.idx) max = temp.idx;	// 마지막 노드까지 비교
		

	}
}

class Printer{

	int idx;
	Printer next;
	Printer prior;

	public Printer(Printer prior, int idx) {
		this.prior = prior;
		this.idx = idx;
	}
}