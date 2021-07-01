package 프로그래머스.깊이_너비우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
 */
public class 여행경로 {

    public static void main(String[] args) {
        여행경로 test = new 여행경로();
        List<String[][]> ticketsTestCases = getTicketsTestCases();
        List<String[]> results = getResultTestCases();

        for (int i = 0; i < ticketsTestCases.size(); i++) {
            String[] result = test.solution(ticketsTestCases.get(i));

            if (Arrays.equals(result, results.get(i))) {
                System.out.printf("성공 : %s \n", Arrays.toString(result));
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", Arrays.toString(result), Arrays.toString(results.get(i)));
            }
        }
    }

    public enum Check {
        S, F
    }

    String[] result;

    public String[] solution(String[][] tickets) {
        Map<String, List<String[]>> ticketsMap = Arrays.stream(tickets)
                .map(n -> {
                    return new String[]{n[0], n[1], Check.F.name()};
                })
                .collect(groupingBy(v -> v[0]));

        ticketsMap.values()
                .forEach(v -> v.sort(comparing(n -> n[1])));

        dfs(new String[tickets.length+1], ticketsMap, "ICN", 0);

        return result;
    }


    private int dfs(String[] tmpArry, Map<String, List<String[]>> ticketsMap, String nextPlace, int idx) {
        int result = 1;
        tmpArry[idx] = nextPlace;

        if (isLastPlace(idx, tmpArry)) {
            this.result = tmpArry;
            return -1;
        }

        for (String[] strings : ticketsMap.getOrDefault(nextPlace, new ArrayList<>())) {
            if (strings[2] == Check.F.name()){
                strings[2] = Check.S.name();
                result *= dfs(tmpArry, ticketsMap, strings[1], idx+1);
                if (result < 0) return -1;
                strings[2] = Check.F.name();
            }
        }
        return result;
    }

    private boolean isLastPlace(int idx, String[] tmpArry){
        return idx == tmpArry.length-1;
    }

    //    ===================================================TEST CASE===========================================================

    public static List<String[]> getResultTestCases(){
        List<String[]> results = new ArrayList<>();
        results.add(new String[]{"ICN", "JFK", "HND", "IAD"});
        results.add(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
        results.add(new String[]{"ICN", "B", "ICN", "A", "D", "A"});
        results.add(new String[]{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"});
        results.add(new String[]{"ICN", "SFO", "ICN", "SFO", "QRE"});
        results.add(new String[]{"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"});
        results.add(new String[]{"ICN","A","B","A","ICN","A"});
        results.add(new String[]{"ICN", "A", "C", "A", "B", "D"});

        return results;
    }


    public static List<String[][]> getTicketsTestCases(){
        String[][] ticket1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] ticket2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] ticket3 = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
        String[][] ticket4 = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
        String[][] ticket5 = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
        String[][] ticket6 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        String[][] ticket7 = {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}};
        String[][] ticket8 = {{"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}};

        List<String[][]> targets = new ArrayList<>();
        targets.add(ticket1);
        targets.add(ticket2);
        targets.add(ticket3);
        targets.add(ticket4);
        targets.add(ticket5);
        targets.add(ticket6);
        targets.add(ticket7);
        targets.add(ticket8);

        return targets;
    }
}
