package Test.__G;

import java.util.*;

public class Test4 {

    public static void main(String[] args) {
        Test4 test = new Test4();
        List<Integer> nTestCases = getNTestCases();
        List<int[][]> edgeTestCases = getEdgeTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < nTestCases.size(); i++) {
            int result = test.solution(nTestCases.get(i), edgeTestCases.get(i));

            if (result ==  results.get(i)) {
                System.out.printf("성공 : %s \n", result);
            } else {
                System.out.printf("실패 : %s , 정답 : %s \n", result, results.get(i));
            }
        }
    }


    public int solution(int n, int[][] edge) {
        int result = 0;
        boolean[][] maps = new boolean[n+1][n+1];
        int[] distance = new int[n+1];

        Arrays.stream(edge)
                .forEach(v -> {
                    maps[v[1]][v[0]] = maps[v[0]][v[1]] = true;
                });

        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(1);

        int maxDist = 0;
        while(!nodes.isEmpty()) {
            int i = nodes.poll();

            for (int j = 2; j <= n; j++) {
                if( distance[j] == 0 && maps[i][j] ) {
                    distance[j] = distance[i] + 1;
                    nodes.add(j);
                    maxDist = Math.max(maxDist,distance[j]);
                    maps[i][j] = maps[j][i] = false;
                }
            }
        }

        for (int d : distance) {
            if( maxDist == d )
                result ++;
        }

        return result;
    }

    public int solution2(int n, int[][] edge) {
        ArrayList<Integer>[] path = new ArrayList[n];
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        int answer = 0;
        int[] dist = new int[n];
        dist[0] = 1;
        int max = 0;

        for(int i = 0; i < edge.length; i++) {
            int num1 = edge[i][0] - 1;
            int num2 = edge[i][1] - 1;
            if(path[num1] == null)
                path[num1] = new ArrayList<Integer>();
            if(path[num2] == null)
                path[num2] = new ArrayList<Integer>();
            path[num1].add(num2);
            path[num2].add(num1);
        }

        bfs.add(0);
        while(!bfs.isEmpty()) {
            int idx = bfs.get(0);
            bfs.remove(0);
            while(!path[idx].isEmpty()) {
                int num = path[idx].get(0);
                path[idx].remove(0);
                bfs.add(num);
                if(dist[num] == 0) {
                    dist[num] = dist[idx] + 1;
                    max = dist[num];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(dist[i] == max)
                answer++;
        }

        return answer;
    }


    private void printVertex (Map<Integer, List<int[]>> vertex) {
        vertex.entrySet()
                .forEach(v -> {
                    System.out.println("key :: " + v.getKey());
                    v.getValue().forEach(g -> {
                        System.out.println("value : " + Arrays.toString(g));
                    });
                });
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
