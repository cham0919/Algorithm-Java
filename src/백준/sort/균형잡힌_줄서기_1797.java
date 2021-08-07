package 백준.sort;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * https://www.acmicpc.net/problem/1797
 */
public class 균형잡힌_줄서기_1797 {

    static int totalManNm = 0;
    static int totalWomanNm = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();

        List<int[]> personList = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int[] tmp = new int[2];
            int sex = scan.nextInt();
            if (sex == 0) {
                sex = -1;
                totalManNm++;
            } else {
                totalWomanNm++;
            }
            tmp[0] = sex;
            tmp[1] = scan.nextInt();
            personList.add(tmp);
        }

        int result = solution(personList);
        System.out.println(result);
    }

    private static int solution(List<int[]> persons) {
        // 1. 정렬
        // 2. 패턴만큼 자른다. 0 과 1의 비율이 5:5
        // 3. 최소값과 최대값 차이가 가장 큰 배열을 선택
        // 4. 차이 return

        persons.sort(comparing(ints -> ints[1]));

        if (persons.size() == 2) { // size가 2일 때는 단순히 둘 사이의 거리를 뺸다. (예외 처리)
            return persons.get(1)[1] - persons.get(0)[1];
        }

        int[] sum = new int[persons.size()];
        Map<Integer, LinkedList<Integer>> idxList = new HashMap<>();

        sum[0] = persons.get(0)[0];
        idxList.put(sum[0], new LinkedList<>(){{add(0);}});

        for (int i = 1; i < persons.size(); i++) {
            sum[i] = sum[i-1] +  persons.get(i)[0];
            LinkedList<Integer> tmpList = idxList.get(sum[i]);
            if (tmpList == null) {
                tmpList = new LinkedList<>();
                tmpList.add(i);
                idxList.put(sum[i], tmpList);
            } else {
                tmpList.add(i);
            }
        }


        int result = idxList.values()
                            .stream()
                            .filter(list -> list.size() > 1)
                            .mapToInt(list -> persons.get(list.getLast())[1] - persons.get(list.getFirst()+1)[1])
                            .max()
                            .getAsInt();

        return result;

        // 패턴
        // 배열 완전탐색하여 합이 0이되는 배열들 추출
        // 0이 1개 일때, 0이 2개일때, 0이 3개일때,,,,


        // 1. -1 idx , 1 idx 비교해 개수 적은 것 기준으로 탐색
        // 2. 전체 길이의 합 구한다.
        // 3. 잔여 값에 대한 앞 뒤의 값을 구한다.
        // 4. 앞뒤로 idx 하나씩 제외 후 2~3 반복
        // 0 0 1 0 1 1


    }
}
