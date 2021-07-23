package 프로그래머스.탐욕법;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */
public class 섬_연결하기 {


    public static void main(String[] args) {
        섬_연결하기 test = new 섬_연결하기();

        List<Integer> numberTestCases  = getNTestCases();
        List<int[][]> kTestCases = getCostsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < numberTestCases.size(); i++) {
            Integer result = test.solution(numberTestCases.get(i), kTestCases.get(i));

            if (result == results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> adj;

    public int solution(int n, int[][] costs) {

        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();

        for(int i = 0 ; i < costs.length ; ++i){
            Edge edge = new Edge(costs[i][0], costs[i][1], costs[i][2]);
            adj.offer(edge);
        }

        for(int i = 0 ; i < n ; ++i) parent[i] = i;

        while(!adj.isEmpty()) {
            Edge edge = adj.poll();

            if(find(edge.from) == find(edge.to)) continue;
            else {
                union(edge.from, edge.to);
                answer += edge.cost;
            }
        }

        return answer;
    }

    public int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootB] = rootA;
    }


    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost)
                return -1;
            else if(this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }


    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(4);

        return results;
    }



    public static List<Integer> getNTestCases(){
        Integer n1 = 4;

        List<Integer> nList = new ArrayList<>();
        nList.add(n1);

        return nList;
    }


    public static List<int[][]> getCostsTestCases(){
        int[][] n1 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        List<int[][]> nList = new ArrayList<>();
        nList.add(n1);

        return nList;
    }
}
