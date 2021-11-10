package 백준.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class 시간_관리_1263 {

    // 하루에 해야할일 총 N개
    // 1번부터 N번까지 번호매김
    // 0시부터 활동 시작, 한번에 하나씩 가능
    // 최대한 늦게 시작하기 위한 계획
    // 소요시간    제한시간
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();

        ArrayList<int[]> workList = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int[] tmp = new int[2];
            for (int j = 0; j < 2; j++) {
                tmp[j] = scan.nextInt();
            }
            workList.add(tmp);
        }

        int result = solution(workList);
        System.out.println(result);
    }

    private static int solution(ArrayList<int[]> workList) {
        // 소요시간    제한시간

        // 1. 제한시간 기준 내림차순
        workList.sort((o1, o2) -> o2[1] - o1[1]);

        // 2. 역순으로 차감
        // 3. 공백 시, 건너기
        // 4. 0 넘어가면 -1 return
        int[] listWork = workList.get(0);
        int currentTime = listWork[1] - listWork[0];
        for (int i = 1; i < workList.size(); i++) {
            int[] work = workList.get(i);
            if (currentTime <= work[1]) {
                currentTime -= work[0];
            } else {
                currentTime = work[1] - work[0];
            }

            if (currentTime < 0) {
                return -1;
            }
        }

        return currentTime;
    }
}
