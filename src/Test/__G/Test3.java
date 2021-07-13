package Test.__G;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        List<Pair> set = new ArrayList<>();
        set.add(new Pair().setPair(new int[]{1,2}));
        System.out.println(set.contains(new Pair().setPair(new int[]{1,2})));
//        countPairs();
    }


    public static int countPairs() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        Set<Integer> integers = new HashSet<>(numbers);
        int k = 1;
        int result = 0;
        for (Integer number : integers) {
            int n = number + k;
            if (n >= 0 && numbers.contains(number + k)) {
                result++;
            }
        }
        System.out.println(result);
        return 0;

    }

    static class Pair {
        private int[] pair;

        public int[] getPair() {
            return pair;
        }

        public Pair setPair(int[] pair) {
            this.pair = pair;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair1 = (Pair) o;
            return Arrays.equals(pair, pair1.pair);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(pair);
        }
    }



    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(3);
        results.add(1);

        return results;
    }



    public static List<int[][]> getEdgeTestCases(){
        int[][] edge1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int[][] edge2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 3}, {3, 5}};

        List<int[][]> edgeList = new ArrayList<>();
        edgeList.add(edge1);
        edgeList.add(edge2);

        return edgeList;
    }

    public static List<Integer> getNTestCases(){
        Integer n1 = 6;
        Integer n2 = 5;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);
        nList.add(n2);

        return nList;
    }
}
