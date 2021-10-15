import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        Test3 test = new Test3();
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

    public int solution(int[][] part_times) {
        //[2, 4, 2]
        //[3, 6, 3]
        //[1, 8, 10]
        //[10, 12, 8]
        //[12, 13, 1]
        //[11, 15, 5]

        int result = 0;


        Arrays.sort(part_times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> part_timeList = new ArrayList<>();

        for (int i = 0; i < part_times.length; i++) {
            int[] part = part_times[i];
            for (int i1 = i+1; i1 < part_times.length; i1++) {
                if (part[0] == part_times[i1][0] &&
                        part[1] == part_times[i1][1]) {
                    // 같으면
                    if (part[2] < part_times[i1][2]) {
                        part = part_times[i1];
                        i = i1;
                    }
                }
            }
            part_timeList.add(part);
        }

        int[] totalMoney = new int[part_timeList.size()];


        // 거꾸로 할 수 있는 선에서 계속 가기
        for (int i = part_timeList.size() - 1; i >= 0; i--) {
            int currentTime = part_timeList.get(i)[0];
            int money = part_timeList.get(i)[2];

            if (totalMoney[i] == 0) {
                // 최대 벌이 추가
                totalMoney[i] = money;
            } else if (totalMoney[i] < money) {
                totalMoney[i] = money;
            } else {
                continue;
            }

            for (int i1 = i; i1 >= 0; i1--) {
                // 시간 되면
                if (currentTime >= part_timeList.get(i1)[1]) {
                    money += part_timeList.get(i1)[2];

                    // 기록이 없으면
                    if (totalMoney[i1] == 0) {
                        // 최대 벌이 추가
                        totalMoney[i1] = money;
                        currentTime = part_timeList.get(i1)[0];
                        result = Math.max(result, money);
                    } else if (totalMoney[i1] < money) {
                        totalMoney[i1] = money;
                        currentTime = part_timeList.get(i1)[0];
                        result = Math.max(result, money);
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(19);
        results.add(4);

        return results;
    }



    public static List<int[][]> getPricesTestCases(){
        int[][] price1 = {{3, 6, 3}, {2, 4, 2}, {10, 12, 8}, {11, 15, 5}, {1, 8, 10}, {12, 13, 1}};
        int[][] price2 = {{1, 2, 1}, {1, 2, 2}, {2, 3, 1}, {3, 4, 1}, {1, 4, 2}};

        List<int[][]> pricesList = new ArrayList<>();
        pricesList.add(price1);
        pricesList.add(price2);

        return pricesList;
    }

}

