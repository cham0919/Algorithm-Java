package 백준.sort;

import java.util.*;

public class 개미_2136 {

    // 줄과 개미들 위치
    // 양수면 오른쪽, 음수며 왼쪽
    // 부딪히면 반대로
    // 가장 마지막에 떨어지는 개미 / 해당 시각 출력
    // 개미 번호는 순서대로 1, 2, 3.....N


    // 다음 개미와 곱이 음수면 충돌, 양수면 평행
    public static void main(String[] args) throws RuntimeException{
        List<Integer> antList = new ArrayList<>();
        PriorityQueue<Integer> antQueue = new PriorityQueue<>((o1, o2) -> Math.abs(o1) - Math.abs(o2));

        Scanner scan = new Scanner(System.in);

        int antSize = scan.nextInt();
        int lineSize = scan.nextInt();
        int leftAntSize = 0;
        int lastAntTime = 0;


        for(int i = 1; i <= antSize; i++) {
            int ant = scan.nextInt();
            if (ant < 0) {
                leftAntSize++;
            }
            lastAntTime = Math.max(lastAntTime, ant < 0 ? Math.abs(ant) : lineSize - ant);
            antList.add(ant);
            antQueue.add(ant);
        }

        for (int i = 0; i < leftAntSize-1; i++) {
            antQueue.poll();
            leftAntSize--;
        }

        int lastAnt = 0;

        if (leftAntSize == 0 || antQueue.size() < 2) {
            lastAnt = antQueue.poll();
        } else {
            int leftAnt = antQueue.poll(); // 왼쪽
            int rightAnt = antQueue.poll(); // 오른쪽
            if (Math.abs(leftAnt) > lineSize - Math.abs(rightAnt)) {
                lastAnt = leftAnt;
            } else {
                lastAnt = rightAnt;
            }
        }


        System.out.println((antList.indexOf(lastAnt)+1) + " " + lastAntTime);

    }
}