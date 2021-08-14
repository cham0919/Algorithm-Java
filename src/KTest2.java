import java.util.stream.IntStream;

public class KTest2 {

    // 필수로 배워야하는 것들
    // 트리
    // 트리 실현
    // 1. check 배열 clone
    // 2. 필수 리프 노드부터 역순 탐색히며 카운팅
    //
    public static void main(String[] args) {
        KTest2 test = new KTest2();
//        int[] t = {0, 0, 1, 1};
//        int[] a = {2};

        int[] t = {0, 0, 0, 0, 2, 3, 3};
        int[] a = {2, 5, 6};

//        int[] t = {0, 0, 1, 2};
//        int[] a = {1, 2};

//        int[] t = {0, 3, 0, 0, 5, 0, 5};
//        int[] a = {4, 2, 6, 1, 0};
        System.out.println(test.solution(t, a));

    }

    private final int LearnedSkill = -1;

    public int solution(int[] skillTree, int[] targetSkills) {
        return IntStream.of(targetSkills)
                .map(targetSkill -> getNeedToSkillPoint(skillTree, targetSkill))
                .sum();
    }

    private int getNeedToSkillPoint(int[] skillTree, int targetSkill) {
        int skillPoint = 0;
        int precedingSkill = 0;
        while (skillTree[targetSkill] != LearnedSkill) {
            skillPoint++;
            precedingSkill = skillTree[targetSkill];
            skillTree[targetSkill] = LearnedSkill;
            if (precedingSkill == LearnedSkill || precedingSkill == targetSkill) {
                break;
            } else {
                targetSkill =  precedingSkill;
            }
        }
        return skillPoint;
    }
}
