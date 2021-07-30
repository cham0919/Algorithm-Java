package 백준.sort;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1129 미결
 */
public class 키_1129 {

	public static void main(String[] args) throws IOException {
		int input1 = 0;
		int[] input2 = null;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input1 = Integer.valueOf(br.readLine());
			input2 = new int[input1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < input1; i++) {
				input2[i] = Integer.valueOf(st.nextToken());
			}
		} catch (IOException e){
			throw new IOException();
		}

		StringBuilder sb = new StringBuilder();
		int[] result = solution(input1, input2);

		for (int i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}

	private static int[] solution(int n, int[] people) {
		Arrays.sort(people);
		if (n <= 2) return people;



		// 최대값
		int max = people[n-1];
		int leftMax = max - people[1];
		int rightMax = max - people[0];

		List<Integer> leftArray = new LinkedList<>();
		List<Integer> rightArray = new LinkedList<>();

		leftArray.add(people[0]);
		leftArray.add(people[1]);

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 2; i < people.length-1; i++) {
			queue.add(people[i]);
		}

		int tmp = 0;

		while (!queue.isEmpty()){
			tmp = queue.poll();
			if (leftMax == rightMax || leftMax > rightMax) {
				leftArray.add(tmp);
				leftMax = max - tmp;
			} else {
				rightArray.add(tmp);
				rightMax = max - tmp;
			}
		}

		int[] result = new int[n];
		int i = 0;
		for (Integer integer : leftArray) {
			result[i++] = integer;
		}

		result[i++] = max;

		for (int i1 = rightArray.size() - 1; i1 >= 0; i1--) {
			result[i++] = rightArray.get(i1);
		}


		return result;
	}
}