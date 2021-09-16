package 프로그래머스;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Base1 {


    public static void main(String[] args) {
        Base1 test = new Base1();
        List<String> kList = getKTestCases();
        List<String> results = getResultTestCases();


        for (int i = 0; i < kList.size(); i++) {

            String result = test.solution(kList.get(i));

            if (result.equals(results.get(i))) {
                System.out.println("성공 : " + result);
            } else {
                System.out.println("실패 : " + result);
            }

        }
    }

    private final String PERFECT = "perfect";


    public String solution(String sentence) {
        sentence = sentence.toLowerCase();
        Set<Integer> alphabetSet = getLowerAlphabetCharSet();
        removeSentenceElements(alphabetSet, sentence);
        String result = getAlphabetStrNotIncludeSentence(alphabetSet);
        return result.length() == 0 ? PERFECT : result;
    }

    private String getAlphabetStrNotIncludeSentence(Set<Integer> alphabetSet) {
        StringBuilder result = new StringBuilder();
        for (Integer integer : alphabetSet) {
            result.append(String.valueOf(Character.toChars(integer)));
        }
        return result.toString();
    }

    private void removeSentenceElements(Set<Integer> alphabetSet, String sentence) {
        char[] sentenceCharArray = sentence.toCharArray();

        for (int i = 0; i < sentenceCharArray.length; i++) {
            int sentenceCharInt = sentenceCharArray[i];
            if (alphabetSet.contains(sentenceCharInt)){
                alphabetSet.remove(sentenceCharInt);
            }
        }
    }

    private Set<Integer> getLowerAlphabetCharSet() {
        Set<Integer> alphabetSet = new HashSet<>();
        for (int i = 97; i <= 122; i++) {
            alphabetSet.add(i);
        }
        return alphabetSet;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<String> getResultTestCases(){
        List<String> results = new ArrayList<>();
        results.add("bjkqvwxz");
        results.add("perfect");

        return results;
    }

    public static List<String> getKTestCases(){
        String k1 = "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";
        String k2 = "Jackdaws love my big sphinx of quartz";

        List<String> ks = new ArrayList<>();
        ks.add(k1);
        ks.add(k2);

        return ks;
    }
}
