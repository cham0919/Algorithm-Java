package stack_queue;


public class 주식가격_programmers {

	public static void main(String[] args) {


		int[] prices = {1,2,3,2,3,1};

		solution(prices);
	}


	public static int[] solution(int[] prices) {

		int[] result = new int[prices.length];
		int[] idx = new int[10001];

		for (int i = 0; i < result.length-1; i++) {

			int cnt = 0;
			int j = 0;

			if(idx[prices[i]] != 0 && i < idx[prices[i]]) {
				result[i] = idx[prices[i]]-i;
			}else {
				for (j = i+1; j < result.length; j++) {
					cnt++;
					if(prices[i] > prices[j]) {
						idx[prices[i]] = j;
						break;
					}else if(j == result.length-1) {
						idx[prices[i]] = j;
						break;
					}
				} // 시간 계산
				result[i] = cnt;
			} // 새로 계산
		} // 주식 가격 배열

		result[result.length-1] = 0;


		return result;
	}

}



