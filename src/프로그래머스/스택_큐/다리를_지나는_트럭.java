package 프로그래머스.스택_큐;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를_지나는_트럭 {

    public static void main(String[] args) {
        다리를_지나는_트럭 test = new 다리를_지나는_트럭();
        List<Integer> bridgeLength = getBridgeLengthTestCases();
        List<Integer> weight = getWeightTestCases();
        List<int[]> truckWeights = getTruckWeightsTestCases();
        List<Integer> results = getResultTestCases();

        for (int i = 0; i < bridgeLength.size(); i++) {
            int result = test.solution(bridgeLength.get(i), weight.get(i), truckWeights.get(i));

            if (result == results.get(i)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }


    }

    int weight;
    int[] truck_weights;

    Deque<Integer> bridge;
    int currentBridgeWeight = 0;
    int currentTruckIdx = 0;
    int bridge_length;
    int result = 0;


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        initParam(bridge_length, weight, truck_weights);

        while (currentTruckIdx < truck_weights.length) {
            moveOneBlock();

            if (isPossibleToaddTruck()) { addTruck(); }

            result++;
        }

        return result + bridge_length;
    }

    private void moveOneBlock() {
        extractTruck();
        addDummy();
    }


    private void addDummy() {
        bridge.addFirst(null);
    }

    private void extractTruck() {
        Integer extractTruck = bridge.pollLast();
        if (extractTruck != null) {
            currentBridgeWeight -= extractTruck;
        }
    }

    private void addTruck() {
        int newTruck = truck_weights[currentTruckIdx++];
        bridge.pollFirst();
        bridge.addFirst(newTruck);
        currentBridgeWeight += newTruck;
    }

    public void initParam(int bridge_length, int weight, int[] truck_weights){
        this.bridge_length = bridge_length;
        this.weight = weight;
        this.truck_weights = truck_weights;
        this.bridge = new LinkedList<>(Arrays.asList(new Integer[bridge_length]));
        this.currentBridgeWeight = 0;
        this.currentTruckIdx = 0;
        this.result = 0;
    }

    public boolean isPossibleToaddTruck(){
        if ( bridge.getFirst() != null ) { return false; }
        else if (currentTruckIdx >= truck_weights.length) { return false; }
        else { return (currentBridgeWeight + truck_weights[currentTruckIdx]) <= weight; }
    }

    //    ===================================================TEST CASE===========================================================

    public static List<Integer> getResultTestCases(){
        List<Integer> results = new ArrayList<>();
        results.add(8);
        results.add(101);
        results.add(110);

        return results;
    }


    public static List<Integer> getBridgeLengthTestCases(){
        Integer bridge_length1 = 2;
        Integer bridge_length2 = 100;
        Integer bridge_length3 = 100;

        List<Integer> bridgeLengths = new ArrayList<>();
        bridgeLengths.add(bridge_length1);
        bridgeLengths.add(bridge_length2);
        bridgeLengths.add(bridge_length3);

        return bridgeLengths;
    }

    public static List<Integer> getWeightTestCases(){
        Integer weight1 = 10;
        Integer weight2 = 100;
        Integer weight3 = 100;

        List<Integer> weights = new ArrayList<>();
        weights.add(weight1);
        weights.add(weight2);
        weights.add(weight3);

        return weights;
    }

    public static List<int[]> getTruckWeightsTestCases(){
        int[] truck_weights1 = {7, 4, 5, 6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        List<int[]> truckWeights = new ArrayList<>();
        truckWeights.add(truck_weights1);
        truckWeights.add(truck_weights2);
        truckWeights.add(truck_weights3);

        return truckWeights;
    }
}

