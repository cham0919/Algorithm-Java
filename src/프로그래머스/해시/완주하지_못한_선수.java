package 프로그래머스.해시;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        List<String[]> participants = getParticipantTestCases();
        List<String[]> completions = getCompletionTestCases();
        List<String> results = getResultTestCases();
        완주하지_못한_선수 test = new 완주하지_못한_선수();

        for (int i = 0; i < participants.size(); i++) {
            String result = test.solution1(participants.get(i), completions.get(i));
            if (result.equals(results.get(i))){
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }

    public String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        for (; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        return participant[i];
    }

    public String solution2(String[] participants, String[] completions) {
        String answer = "";
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (String player : participants) playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);
        for (String player : completions) playerMap.put(player, playerMap.get(player) - 1);

        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            if (entry.getValue() != 0){
                return entry.getKey();
            }
        }
        return null;
    }

//    ===================================================TEST CASE===========================================================

    public static List<String> getResultTestCases(){
        List<String> results = new ArrayList<>();
        results.add("leo");
        results.add("vinko");
        results.add("mislav");

        return results;
    }


    public static List<String[]> getCompletionTestCases(){
        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        List<String[]> completions = new ArrayList<>();
        completions.add(completion1);
        completions.add(completion2);
        completions.add(completion3);

        return completions;
    }

    public static List<String[]> getParticipantTestCases(){
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

        List<String[]> participants = new ArrayList<>();
        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);

        return participants;
    }
}
