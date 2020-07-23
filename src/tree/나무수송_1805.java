package tree;

import java.io.*;
import java.util.*;

public class 나무수송_1805 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken()); // 왕국을 제외한 마을 수

		int spotsize = Integer.parseInt(st.nextToken()); // 목공소 수

		int[] spot = new int[size+1]; // 목공소 배열
		
		
		
		Node_1805[] temp = new Node_1805[size+1]; // 마을 정보 배열

		temp[0] = new Node_1805(0, -1, 0, 0); // 0 인덱스에 왕국 생성

		Tree_Move tree = new Tree_Move();

		for (int i = 1; i <= size; i++) {  // 마을 수 만큼 반복
			st =  new StringTokenizer(br.readLine());
			int tree_cnt = Integer.parseInt(st.nextToken());  	// 마을의 나무 갯수
			int next_idx = Integer.parseInt(st.nextToken());	// 다음 마을 인덱스
			int rode = Integer.parseInt(st.nextToken());		// 다음 마을까지의 거리
			temp[i] = new Node_1805(i, next_idx, tree_cnt, rode); // 마을 생성 후 입력
		}

		br.close();
		
		for (int i = 1; i < temp.length; i++) {
			int r = 0;
			Node_1805 n = temp[i];
		
			while(n.next_idx != -1) {
				r += n.rode;
				n = temp[n.next_idx];
			}
			
			temp[i].full_rode = r;
		}
		
		
		for (int i = 1; i <= size; i++) {

			Node_1805 n = temp[i];	// 임시 저장
			
			while (n.next_idx != -1) {				// 왕국에 도달할 떄까지 반복
				n.ga += temp[i].tree_cnt * n.full_rode;	// n 마을을 거쳐가는 원목들 비용
				n = temp[n.next_idx];				// 다음 마을
			}
		}

		for (int i = 1; i < spot.length; i++) {
			spot[i] = i;
		}
//		System.out.println(Arrays.toString(spot));
		
		for (int i = 1; i < spot.length-1; i++) {
			for (int j = i+1; j < spot.length; j++) {
				if(tree.compare(temp[spot[i]], temp[spot[j]]) < 0) {
					int t = spot[i];
					spot[i] = spot[j];
					spot[j] = t;
				}
			}
		}
		
		
		int[] s = new int[spotsize];
		for (int i = 0; i < s.length; i++) {
			s[i] = spot[i+1];
		}
		
		Arrays.sort(s);

		System.out.println(tree.move(s, temp));
	}
}

class Node_1805{

	public int idx;			// 마을 인덱스
	public int next_idx;	// 다음 마을 인덱스
	public int tree_cnt;	// 나무 갯수
	public int rode;		// 거리
	public int full_rode;		// 거리
	public long ga = 0;		// 해당 거쳐가는 축적된 비용

	public Node_1805(int idx, int next_idx, int tree_cnt, int rode) {
		this.idx = idx;
		this.next_idx = next_idx;
		this.tree_cnt = tree_cnt;
		this.rode = rode;
	}

}

class Tree_Move implements Comparator<Node_1805>{

	public long move(int[] s, Node_1805[] arr) {

		long result = 0;
		for (int i = 1; i < arr.length; i++) {
			Node_1805 n = arr[i];
			 if(Arrays.binarySearch(s, n.idx) < 0 && n.next_idx != -1){ // 왕국까지 가거나 목공소에 도달하면 멈춤
				result += (arr[i].tree_cnt * n.rode);	// 그때까지 비용 축적
				n = arr[n.next_idx];
			}
		}
		return result;
	}

	@Override
	public int compare(Node_1805 o1, Node_1805 o2) {
		if(o1.ga > o2.ga) {
			return 1;
		}else {
			return -1;
		}
	}

}
