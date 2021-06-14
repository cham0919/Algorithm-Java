package 프로그래머스.해시;

import java.util.*;
import static java.util.stream.Collectors.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=python3
 */
public class 위장 {

    public static void main(String[] args) {
        위장 test = new 위장();
        List<String[][]> clothesList = getClothesTestCases();
        List<Integer> results = getResultTestCases();


        for (int i = 0; i < clothesList.size(); i++) {

            int result = test.solution1(clothesList.get(i));
            
            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        }
    }


    public int solution1(String[][] clothes) {
        int result = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] value :clothes){
            map.put(value[1], map.getOrDefault(value[1], 0) + 1);
        }

        for (int v  : map.values()){
            result *= v+1;
        }

        return result-1;
    }

    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<String[][]> getClothesTestCases(){
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        List<String[][]> clothesList = new ArrayList<>();
        clothesList.add(clothes1);
        clothesList.add(clothes2);

        return clothesList;
    }

    public static List<Integer> getResultTestCases(){
        Integer result1 = 5;
        Integer result2 = 3;

        List<Integer> results = new ArrayList<>();
        results.add(result1);
        results.add(result2);

        return results;
    }
}
