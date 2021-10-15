import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        Test1 test = new Test1();
        List<String[]> pricesTestCases = getPricesTestCases();
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

    public int solution(String[] room) {
        // 첫번째 청소.
        // 조건 1. 아래가 #이면 제거
        // 조건 2. 아래가 #이 아니면 차후 청소

        // $ 먼지
        // # 틀
        // . 깨끗

        // 1 치워야 된다
        // 0 치울게 없다
        int result = 0;
        int[] dustArray = new int[room[0].length()];
        char[][] dustRoom = new char[room.length][room[0].length()];


        for (int i = 0; i < dustRoom.length; i++) {
            dustRoom[i] = room[i].toCharArray();
        }

        for (int i = 0; i < dustRoom.length; i++) {
            for (int i1 = 0; i1 < dustRoom[i].length; i1++) {
                if (dustRoom[i][i1] == '$') {
                    result++;
                    // 청소해야할 곳이면 치운다
                    if (i+1 < dustRoom.length && dustRoom[i+1][i1] == '#') {
                        // 치우고 삭제
                        dustArray[i1] = 0;
                    } else {
                        // 밑으로 떨어뜨리기
                        dustArray[i1] = 1;
                    }
                } else if (i+1 < dustRoom.length && dustRoom[i+1][i1] == '#' && dustArray[i1] == 1) {
                    result++;
                    dustArray[i1] = 0;
                }
            }
        }



        return result;
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(10);

        return results;
    }



    public static List<String[]> getPricesTestCases(){
        String[] price1 = {".$.$$.", "$....$", ".$..##", "$....#", "######"};

        List<String[]> pricesList = new ArrayList<>();
        pricesList.add(price1);

        return pricesList;
    }

}

