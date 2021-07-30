package 백준.sort;

import java.io.*;
import java.util.*;
import java.util.stream.*;

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

		List<Integer> peopleList = IntStream.of(people)
				.boxed()
				.collect(Collectors.toList());

		// 최대값
		int max = peopleList.get(n-1) - peopleList.get(0);
		int idx = n-2;

		while (idx > 0) {

			while (idx > 0
					&& (peopleList.get(idx) - peopleList.get(0) >= max
					|| peopleList.get(idx+1) - peopleList.get(idx-1) >= max
					|| peopleList.get(n-1) - peopleList.get(idx) >= max)){
				idx--;
			};

			if (idx == 0) break;
			max = peopleList.get(idx) - peopleList.get(0);
			switchArray(peopleList, idx);
			idx--;
		}

		return peopleList.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void switchArray(List<Integer> peopleList, int idx) {
		int changeNum = peopleList.remove(idx);
		peopleList.add(changeNum);
	}
}