import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class KTest3 {

    // First.Last@email.com
    // 하이픈 들어가면 안됨
    // 중복되면 @앞에 2, 3 붙이기

    public static void main(String[] args) {
        KTest3 test = new KTest3();
//        int[] s = {3, 2, 3, 2, 3};
        int[] s = {7, 4, -2, 4, -2, -9};
        System.out.println(test.solution(s));

    }

    // 처음부터 규칙을 찾아 완전탐색을 한다.
    // 실패하면 max 값을 업데이트 한 후, 그 다음 값부터 다시 시작한다

    public int solution(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length;) {
            int swichingSliceCount = findMaxSwichingSliceCount(A, i);
            result = Math.max(result, swichingSliceCount);
            i += swichingSliceCount > 2 ? swichingSliceCount : 1;
        }
        return result;
    }

    private int findMaxSwichingSliceCount(int[] A, int idx){
        if (idx+1 >= A.length) return 1;
        int swichingSliceCount = 0;
        int[] standardNm = {A[idx], A[idx+1]};

        for (int i = idx; i < A.length; i++) {
            if (A[i] == standardNm[(i - idx)%2]) {
                swichingSliceCount++;
            } else {
                break;
            }
        }

        return swichingSliceCount;
    }
}
