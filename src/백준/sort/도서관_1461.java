package 백준.sort;

import java.util.*;

public class 도서관_1461 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int box =  scan.nextInt();

        ArrayList<Integer> books = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            books.add(scan.nextInt());
        }

        int result = solution(books, box);
        System.out.println(result);
    }



    private static int solution(ArrayList<Integer> books, int boxSize) {
        Queue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());

        books.forEach(i -> {
            if (i >= 0) {
                positive.add(i);
            } else {
                negative.add(i*-1);
            }
        });

        int element;
        int max = 0;
        int sum = 0;
        //양수가 없을때까지
        while (!positive.isEmpty()) {
            //한번의 이동에 M개의 책을 가져올 수 있다.
            for (int i = 0; i < boxSize; i++) {
                //M개씩 가져오다보면 마지막에 M개보다 부족 할 수 있기 때문에 continue 함수를 써서 넘어간다.
                //continue 안하면 에러
                if (positive.isEmpty())
                    continue;
                element = positive.poll();

                //처음 가는 곳이 제일 거리가 먼곳이므로 이때만 거리를 더해주면 된다.
                if (i == 0) {
                    sum += Math.abs(element);
                    if (Math.abs(element) > max) {
                        max = Math.abs(element);
                    }
                }
            }
        }
        //음수 일때
        while (!negative.isEmpty()) {
            //한번의 이동에 M개의 책을 가져올 수 있다.
            for (int i = 0; i < boxSize; i++) {
                //M개씩 가져오다보면 마지막에 M개보다 부족 할 수 있기 때문에 continue 함수를 써서 넘어간다.
                //continue 안하면 에러
                if (negative.isEmpty())
                    continue;
                element = negative.poll();

                //처음 가는 곳이 제일 거리가 먼곳이므로 이때만 거리를 더해주면 된다.
                if (i == 0) {
                    sum += element;
                    if (element > max) {
                        max = element;
                    }
                }
            }
        }

        return sum * 2 - max;
    }



}
