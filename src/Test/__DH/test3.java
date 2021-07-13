package Test.__DH;

import java.util.ArrayList;
import java.util.List;

public class test3 {

    public static void main(String[] args) {
        String a = "babaa";
        String b = "ababa";
        String c = "aba";
        String d = "bbbbb";
//        Test.딜리버리히어로.test3 test = new Test.딜리버리히어로.test3();
//        test.solution(a);

        Integer tt = new Integer(10);
        aaa(tt);
        System.out.println(tt);
    }

    public static void aaa(Integer tt){
        tt = 1;
    }

    public int solution(String S) {
        // write your code in Java SE 8
        if (S.contains("a")) {
            splitThreeParts(S);
        } else {

        }

        return 0;
    }

    private int splitThreeParts(String S) {
        char[] charArray = S.toCharArray();
        List<Integer> idxList = new ArrayList<>();
        idxList.add(S.indexOf("a"));
        idxList.add(S.indexOf("a", idxList.get(0)+1));
        idxList.add(S.indexOf("a", idxList.get(1)+1));

        if (idxList.contains(-1)) {
            return 0;
        } else if (isValidate(charArray, idxList)) {

        }
            return 0;
    }

    private boolean isValidate(char[] charArray, List<Integer> idxList) {
        return true;
    }
}
