package 백준.sort;

import java.io.IOException;
import java.util.*;

public class 순회강연_2109 {

    // 1. 강의들 기한 순대로 정렬
    // 2. 1일 중 큰 곳 강의 ㄱ
    // 3. 2일 중 큰 곳 강의 ㄱ
    // 4. 3일 중 큰 곳 강의 ㄱ
    // 5. ....



    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        List<LessonOfDay> lessonOfDayList = new ArrayList<>();

        int size = scan.nextInt();

        for(int i = 0; i < size; i++) {
            int day = scan.nextInt();
            int pay = scan.nextInt();
            LessonOfDay lessonOfDay = LessonOfDay.of()
                    .setDeadLineDay(day)
                    .addPayList(pay);

            lessonOfDayList.add(lessonOfDay);
        }

         int result = solution(lessonOfDayList);

        System.out.println(result);
    }

    // 주의사항
    // 1. 1일차보다 2일차가 주는 돈이 월등히 많다면?
    // ex) 1일 5, 2일 10, 2일 20
    // 1일을 skip, 2일차만 순회
    // ex) 1일 5, 2일 10 20, 3일 50
    // 1일 skip, 2일 2번, 3일 한번
    // 1일차(가장 높은 순위), 2일차(가장 낮은 순위), 3일차(가장 낮은 순위)... 중 최대값 선택

    // 2. 차이가 있지만 기간이 많이 차이난다면?
    // ex) 1일 5, 10일 1000 20000, 50일 100, 200, 300.....
    // 1번대로라면 10일차를 먼저 가겠지만, 기간도 계산하여 1일 skip하면 안됨
    // 기간이 겹치는지 확인
    // today만큼 우선순위에서 빼내기



    // 겹치는 날짜가 있는지 확인
    // (day - lesson.size()) >= today.size()

    // 겹치는 만큼 비교(빡빡한 페이 최대값, 느슨한 페이 최소값)
    // int duplicateLessonSize = day - lesson.size() - today.size()
    // duplicateLessonSize.fori
    // day.getMinLession > today.getMaxLession => today => day
    // day.getMinLession < today.getMaxLession => today 진행
    // day.getMinLession == today.getMaxLession => 다음날짜 진행

    // 일차별로 리스트 and 정렬? 범위가 10_000이라 음,,,,
    // 일단 해볼까?
    private static int solution(List<LessonOfDay> lessonOfDayList) {
        // 데드라인 순으로 정렬 / 내부 페이순으로 정렬
        lessonOfDayList.sort(Comparator.comparing(LessonOfDay::getDeadLineDay));
        lessonOfDayList.forEach(lessonOfDay -> lessonOfDay.getPayList().sort(Integer::compareTo));


        LessonOfDay priorityLessonDay = getAndDelPriorityLessonOfDay(lessonOfDayList);

        return 0;
    }

    private static void sortlessons(Map<Integer, LinkedList<Integer>> lessonMap) {
        for (LinkedList<Integer> lessonList : lessonMap.values()) {
            lessonList.sort(Integer::compareTo);
        }
    }

    private static LessonOfDay getAndDelPriorityLessonOfDay(List<LessonOfDay> lessonOfDayList) {
        LessonOfDay lessonOfDay = lessonOfDayList.get(0);
        if (lessonOfDay.isExistConflictDay()) {
            // 충돌나는 레슨 중 우선순위 결정
            int idx = getPriorityLessonOfDayIdx(lessonOfDayList);
        } else {
            return lessonOfDayList.remove(0);
        }
        return null;
    }

    // 우선순위 결정
    private static int getPriorityLessonOfDayIdx(List<LessonOfDay> lessonOfDayList) {
        int priorityLessonOfDayIdx = 0;
        LessonOfDay priorityLessonOfDay = lessonOfDayList.get(priorityLessonOfDayIdx);

        for (int i = 1; i < lessonOfDayList.size(); i++) {
            LessonOfDay conflictLessonOfDay = lessonOfDayList.get(i);
            List<Integer> conflictDayPayList = conflictLessonOfDay.getPayList();
            int compateResult = compareToConflictLessonOfDay(priorityLessonOfDay.getPayList(), conflictDayPayList);
            if (compateResult < 0) {
                priorityLessonOfDayIdx = i;
                priorityLessonOfDay = conflictLessonOfDay;
            }
        }
        return priorityLessonOfDayIdx;
    }

    private static int compareToConflictLessonOfDay(List<Integer> todayPayList, List<Integer> conflictDayPayList) {
        int compareResult = 0;
        int conflictDayPayListIdx = 0;

        for (int i = todayPayList.size() - 1; i >= 0; i--) {
            compareResult = todayPayList.get(i) - conflictDayPayList.get(conflictDayPayListIdx++);
            if (compareResult == 0) {
                continue;
            } else {
                return compareResult;
            }
        }
        return compareResult;
    }
}


class LessonOfDay {
    private List<Integer> payList = new ArrayList();
    private int deadLineDay;
    private List<Integer> conflictDay = new ArrayList<>();

    private LessonOfDay() {}

    public static LessonOfDay of() {
        return new LessonOfDay();
    }

    public boolean isExistConflictDay(){
        return conflictDay.size() > 0;
    }

    public int getMinPay(){
        if (payList.size() > 0) {
            return payList.get(0);
        } else {
            return 0;
        }
    }

    public int getMaxPay(){
        if (payList.size() > 0) {
            return payList.get(payList.size() - 1);
        } else {
            return 0;
        }
    }

    public List<Integer> getPayList() {
        return payList;
    }

    public LessonOfDay addPayList(int pay) {
        payList.add(pay);
        return this;
    }

    public int getDeadLineDay() {
        return deadLineDay;
    }

    public LessonOfDay setDeadLineDay(int deadLineDay) {
        this.deadLineDay = deadLineDay;
        return this;
    }

    public List<Integer> getConflictDay() {
        return conflictDay;
    }

    public LessonOfDay setConflictDay(List<Integer> conflictDay) {
        this.conflictDay = conflictDay;
        return this;
    }
}


