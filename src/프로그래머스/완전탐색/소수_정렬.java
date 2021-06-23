package 프로그래머스.완전탐색;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class 소수_정렬 {

    public static void main(String[] args){
        소수_정렬 test = new 소수_정렬();
        List<String> numbersTestCases = getNumbersTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numbersTestCases.size(); i++) {
            int result = test.solution(numbersTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    Set<Integer> primeSet;
    char[] chars;
    int result = 0;

    public int solution(String numbers) {
        System.out.println(numbers);
        chars = numbers.toCharArray();
        primeSet = new HashSet<>();
        result = 0;

        for (int i = 0; i < chars.length; i++) {
            char[] array = new char[i+1];
            int[] check = new int[chars.length];
            permutation(array, 0, check);
        }

        Iterator<Integer> iter = primeSet.iterator();

        while (iter.hasNext()) {
            if (isPrime(iter.next())) { result++; }
        }
        return result;
    }

    private void permutation(char[] array, int depth, int[] check) {
            for (int i = 0; i < chars.length; i++) {
                if (check[i] == 1) { continue; }
                array[depth] = chars[i];
                if (isLastPermutation(array, depth)) {
                    addPrime(array);
                } else {
                    check[i] = 1;
                    permutation(array, depth+1, check);
                    check[i] = 0;
            }
        }
    }

    private void addPrime(char[] array){
        Integer prime = mapToInteger(array);
        primeSet.add(prime);
    }

    private boolean isLastPermutation(char[] array, int depth) {
        return depth == array.length-1;
    }

    private Integer mapToInteger(char[] array) {
        StringBuffer sb = new StringBuffer();
        for (char c : array) {
            sb.append(c);
        }
        return Integer.valueOf(sb.toString());
    }

    public boolean isPrime(int num){
        if (num < 2) { return false; }
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        System.out.println(num);
        return true;
    }

    //    ===================================================2===========================================================


    public int solution2(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime2(a)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime2(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(3);
        results.add(2);

        return results;
    }

    public static List<String> getNumbersTestCases(){
        String answers1 = "17";
        String answers2 = "011";

        List<String> numbersList = new ArrayList<>();
        numbersList.add(answers1);
        numbersList.add(answers2);

        return numbersList;
    }
}
