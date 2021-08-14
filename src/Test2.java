import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Test2 test = new Test2();
        List<int[][]> pricesTestCases = getPricesTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < pricesTestCases.size(); i++) {
            int result = test.solution(pricesTestCases.get(i));

            if (result ==  results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    int[] start;
    int[] exit;
    LinkedList<int[]> fixedCarQueue = new LinkedList<>();

    // 출구부터 4와 인접한 칸들은 모두 4로 채우기
    // 막힌 빨간 차가 있을 시, 큐에 넣기
    //
    public int solution(int[][] cars) {
        start = null;
        exit = null;
        fixedCarQueue.clear();
        // 채우기 0, 1, -1
        findEndPoint(cars);
        dfsExitToStart(cars, exit[0], exit[1]);
        if (cars[start[0]][start[1]] < 4) {
            return -1;
        } else {
            return cars[start[0]][start[1]] - 4;
        }
    }

    private void dfsExitToStart(int[][] cars, int idx1, int idx2) {
        if (!isWithinRange(cars, idx1, idx2)) {
            return;
        }

        int val = 4;

        // 상, 하, 좌, 우 탐색하며 0이면 모두 4로 전염
        dfsFillParkingLot(cars, val, idx1 -1, idx2);
        dfsFillParkingLot(cars, val, idx1 +1, idx2);
        dfsFillParkingLot(cars, val, idx1, idx2 -1);
        dfsFillParkingLot(cars, val, idx1, idx2 +1);

        // 탐색했는데 출발점에 닿지 않았고 큐에 값이 있다면
        while (cars[start[0]][start[1]] < val && !fixedCarQueue.isEmpty()) {
            int[] tmpArray = fixedCarQueue.removeFirst();
            idx1 = tmpArray[0];
            idx2 = tmpArray[1];

            dfsFillParkingLot(cars, cars[idx1][idx2], idx1 -1, idx2);
            dfsFillParkingLot(cars, cars[idx1][idx2], idx1 +1, idx2);
            dfsFillParkingLot(cars, cars[idx1][idx2], idx1, idx2 -1);
            dfsFillParkingLot(cars, cars[idx1][idx2], idx1, idx2 +1);
        }
        return;
    }

    private void findEndPoint(int[][] cars) {
        for (int i = 0; i < cars.length; i++) {
            for (int i1 = 0; i1 < cars[i].length; i1++) {
                if (cars[i][i1] == 1) {
                    start = new int[]{i, i1};
                } else if (cars[i][i1] == 4) {
                    exit = new int[]{i, i1};
                } else if (start != null && exit != null) {
                    return;
                }
            }
        }
    }

    private void dfsFillParkingLot(int[][] cars, int val, int idx1, int idx2) {
        // 범위 밖이거나 출발점에 값이 있으면 반환
        if (!isWithinRange(cars, idx1, idx2)) {
            return;
        } else if (cars[start[0]][start[1]] >= 4 ) {
            return;
        }

        // 값 대입
        int carType = cars[idx1][idx2];
        if (carType >= 4) {
            return;
        }
        if (carType == 0) {
            cars[idx1][idx2] = val;
        } else if (carType == 2) {
            cars[idx1][idx2] = val+1;
            fixedCarQueue.add(new int[]{idx1, idx2});
            return;
        } else if (carType == 3) {
            return;
        } else if (carType == 1) {
            cars[idx1][idx2] = val;
            return;
        }

        // 다시 상하좌우 참색
        dfsFillParkingLot(cars, val, idx1 -1, idx2);
        dfsFillParkingLot(cars, val, idx1 +1, idx2);
        dfsFillParkingLot(cars, val, idx1, idx2 -1);
        dfsFillParkingLot(cars, val, idx1, idx2 +1);
    }

    private boolean isWithinRange(int[][] cars, int idx1, int idx2) {
        return idx1 >= 0 && idx1 < cars.length && idx2 >= 0 &&  idx2 < cars[0].length;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(2);
        results.add(0);
        results.add(-1);

        return results;
    }



    public static List<int[][]> getPricesTestCases(){
        int[][] price1 = {{0, 0, 3, 0, 0, 0, 0}, {1, 0, 3, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0, 0}, {0, 0, 2, 0, 0, 3, 3}, {2, 2, 2, 0, 2, 0, 0}, {3, 3, 2, 0, 2, 0, 3}, {3, 3, 2, 0, 2, 0, 4}};
        int[][] price2 = {{0, 2, 0, 0, 0}, {0, 4, 2, 0, 0}, {0, 2, 0, 0, 0}, {0, 0, 0, 2, 1}, {0, 0, 0, 2, 0}};
        int[][] price3 = {{0, 0, 0, 0, 0}, {3, 0, 0, 0, 0}, {4, 3, 0, 0, 0}, {0, 0, 3, 0, 0}, {0, 0, 0, 3, 1}};

        List<int[][]> pricesList = new ArrayList<>();
        pricesList.add(price1);
        pricesList.add(price2);
        pricesList.add(price3);

        return pricesList;
    }

}
