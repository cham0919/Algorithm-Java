package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1132
public class 합_1132 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

//      1. 변수 중 사이즈가 가장 큰 수 탐색
//      2. 사이즈 가장 큰 수 탐색
//      3. 값 할당되어있는지 체크
//      4. 할당안되어 있으면 가장 큰 수 할당
//      5. 사이즈가 동일한게 여러개일 경우
//      6. 해당 값이 다음 탐색 통해 가장 먼저 나오는 값에 할당
//      3. 자리수 카운팅 후, 1번 ~ 3번 반복
//      4. 마지막 한자리 수가 있을시, 3번에게 0 양도 후 1 할당

        char[] alphabetArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Map<Character, Alphabet> alphabetMap = new HashMap<>();
        for (char c : alphabetArray) {
            alphabetMap.put(c, new Alphabet());
        }


        
        List<String> numberList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] tempAlphabetArray = st.nextToken().toCharArray();
            for (int c : tempAlphabetArray) {

            }

        }

        char a = 'A'; // 65
        char j = 'J'; // 74

        System.out.println((int)j);
    }
}

class Alphabet {

    private boolean isAssign = false;
    private int value = 0;
    private int[] useIndex = new int[12];

    public boolean isAssign() {
        return isAssign;
    }

    public Alphabet setAssign(boolean assign) {
        isAssign = assign;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Alphabet setValue(int value) {
        this.value = value;
        return this;
    }
}
