package 백준.sort;

import java.util.*;

public class 강의실_1374 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();

        ArrayList<int[]> lessions = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int[] tmp = new int[3];
            for (int j = 0; j < 3; j++) {
                tmp[j] = scan.nextInt();
            }
            lessions.add(tmp);
        }

        int result = solution(lessions);
        System.out.println(result);
    }

    private static int solution(ArrayList<int[]> lessions) {
        Queue<Integer> queue = new PriorityQueue();

        lessions.sort((o1, o2) -> {
            if (o1[1] - o2[1] == 0 ) {
                return o1[2] - o2[2];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] lession : lessions) {
            if (!queue.isEmpty()) {
                if (queue.peek() <= lession[1]) {
                    queue.poll();
                }
            }
            queue.add(lession[2]);
        }

        return queue.size();
    }
}
