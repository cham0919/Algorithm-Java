package stack_queue;

import java.util.LinkedList;
import java.util.List;

public class 다리를지나는트럭_programmers {

	public static void main(String[] args) {


		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};

		solution(bridge_length, weight, truck_weights);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int idx = 0;	// 차 인덱스
		int max_wei = 0;	// 현재 다리 올라가있는 차 무게
		int result = 0;
		List<Truck> ll = new LinkedList<Truck>();

		do{
			result++;
			for (int i = 0; i < ll.size(); i++) {
				Truck t = ll.get(i);
				t.cnt++;
				if(t.cnt == bridge_length) {
					ll.remove(t);
					max_wei -= t.weigth;
					i--;
				}
			}

			if(idx < truck_weights.length && max_wei+truck_weights[idx] <= weight) {
				ll.add(new Truck(truck_weights[idx]));
				max_wei += truck_weights[idx++];
			}
			
		}while (!ll.isEmpty());

		return result;
	}
}

class Truck{

	int weigth;
	int cnt;

	public Truck(int weigth) {
		this.weigth = weigth;
		cnt = 0;
	}
}
