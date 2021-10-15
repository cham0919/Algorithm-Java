import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Test2 test = new Test2();
        List<int[]> pricesTestCases = getPricesTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < pricesTestCases.size(); i++) {
            int result = test.solution(pricesTestCases.get(i));

            if (result ==  results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    public int solution(int[] numbers) {
        int result = 0;
        int[] bite = new int[numbers.length];

        for (int i = 0; i < bite.length; i++) {
            bite[i] = getBit(numbers[i], numbers.length, i);
        }


        int number = 1;

        if (bite[0] == 1) {
            result += number;
        }

        for (int i = 1; i < bite.length; i++) {
            number *= 2;

            if (bite[i] == 1) {
                result += number;
            }
        }

        return result;
    }


    public int getBit(int number, int size, int flag){
        if (number == 0) {
            return 0;
        }

        long num = 1;
        int idx = size;
        int[] bite = new int[size];

        if (size > 1) {
            for (int i = 0; i < size; i++) {
                num *= 2;
            }
        }


        while (number < num) {
            num /= 2;
            idx --;
        }

        for (int i = idx; i >= flag; i--) {
            if (number > num) {
                number -= num;
                bite[i]++;
            } else if (number == num) {
                bite[i]++;
                break;
            }
                num /= 2;
        }

        return bite[flag];
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(19);
        results.add(15);
        results.add(0);

        return results;
    }



    public static List<int[]> getPricesTestCases(){
        int[] price1 = {5, 27, 9, 0, 31};
        int[] price2 = {1, 2, 4, 8};
        int[] price3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        List<int[]> pricesList = new ArrayList<>();
        pricesList.add(price1);
        pricesList.add(price2);
        pricesList.add(price3);

        return pricesList;
    }

}

